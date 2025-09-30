<template>
  <div class="blog-page">
    <!-- Page Header -->
    <div class="page-header">
      <div class="container">
        <h1>技术博客</h1>
        <p>分享前端开发经验、技术心得和最佳实践</p>
      </div>
    </div>

    <!-- Blog Content -->
    <div class="blog-content">
      <div class="container">
        <!-- Filters -->
        <div class="filters">
          <div class="filter-group">
            <label>分类:</label>
            <select v-model="selectedCategory" class="filter-select">
              <option value="">全部</option>
              <option 
                v-for="category in categories" 
                :key="category" 
                :value="category"
              >
                {{ category }}
              </option>
            </select>
          </div>
          
          <div class="filter-group">
            <label>排序:</label>
            <select v-model="sortBy" class="filter-select">
              <option value="date">最新</option>
              <option value="views">最热</option>
              <option value="title">标题</option>
            </select>
          </div>

          <div class="search-group">
            <input
              type="text"
              v-model="searchQuery"
              placeholder="搜索文章..."
              class="search-input"
            />
            <span class="search-icon">🔍</span>
          </div>
        </div>

        <!-- Blog Grid -->
        <div class="blog-grid">
          <article 
            v-for="post in filteredPosts" 
            :key="post.id"
            class="blog-card"
          >
            <div class="card-image">
              <img 
                :src="post.image" 
                :alt="post.title"
                loading="lazy"
              />
              <div class="card-category">{{ post.category }}</div>
            </div>
            
            <div class="card-content">
              <h2 class="card-title">{{ post.title }}</h2>
              <p class="card-excerpt">{{ post.excerpt }}</p>
              
              <div class="card-meta">
                <div class="meta-left">
                  <span class="meta-date">{{ formatDate(post.date) }}</span>
                  <span class="meta-read-time">{{ post.readTime }}</span>
                </div>
                <div class="meta-right">
                  <span class="meta-views">👁️ {{ post.views }}</span>
                  <span class="meta-likes">❤️ {{ post.likes }}</span>
                </div>
              </div>
              
              <div class="card-tags">
                <span 
                  v-for="tag in post.tags" 
                  :key="tag"
                  class="tag"
                >
                  {{ tag }}
                </span>
              </div>
              
              <router-link 
                :to="`/blog/${post.id}`" 
                class="card-link"
              >
                阅读全文 →
              </router-link>
            </div>
          </article>
        </div>

        <!-- No Results -->
        <div v-if="filteredPosts.length === 0" class="no-results">
          <h3>没有找到相关文章</h3>
          <p>尝试调整搜索条件或选择其他分类</p>
        </div>

        <!-- Pagination -->
        <div v-if="filteredPosts.length > 0" class="pagination">
          <button 
            @click="currentPage--" 
            :disabled="currentPage === 1"
            class="pagination-btn"
          >
            上一页
          </button>
          
          <span class="pagination-info">
            第 {{ currentPage }} 页 / 共 {{ totalPages }} 页
          </span>
          
          <button 
            @click="currentPage++" 
            :disabled="currentPage === totalPages"
            class="pagination-btn"
          >
            下一页
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'

const selectedCategory = ref('')
const sortBy = ref('date')
const searchQuery = ref('')
const currentPage = ref(1)
const postsPerPage = 6

// Sample blog posts data
const blogPosts = [
  {
    id: 1,
    title: 'Vue 3 Composition API 最佳实践',
    excerpt: '深入探讨 Vue 3 Composition API 的使用技巧和最佳实践，帮助您写出更优雅的代码。',
    category: 'Vue.js',
    date: '2024-01-15',
    readTime: '8分钟阅读',
    views: 1245,
    likes: 89,
    tags: ['Vue3', 'Composition API', '最佳实践'],
    image: 'https://picsum.photos/400/250?random=5'
  },
  {
    id: 2,
    title: 'JavaScript 异步编程完全指南',
    excerpt: '从回调函数到 async/await，全面解析 JavaScript 异步编程的各种模式和技巧。',
    category: 'JavaScript',
    date: '2024-01-10',
    readTime: '12分钟阅读',
    views: 2897,
    likes: 156,
    tags: ['JavaScript', '异步', 'Promise'],
    image: 'https://picsum.photos/400/250?random=6'
  },
  {
    id: 3,
    title: 'CSS Grid 布局实战教程',
    excerpt: '通过实际案例学习 CSS Grid 布局的强大功能，创建复杂的响应式页面布局。',
    category: 'CSS',
    date: '2024-01-05',
    readTime: '6分钟阅读',
    views: 1876,
    likes: 102,
    tags: ['CSS', 'Grid', '布局'],
    image: 'https://picsum.photos/400/250?random=7'
  },
  {
    id: 4,
    title: 'React Hooks 深度解析',
    excerpt: '深入理解 React Hooks 的工作原理和使用场景，提升组件开发效率。',
    category: 'React',
    date: '2023-12-20',
    readTime: '10分钟阅读',
    views: 1567,
    likes: 94,
    tags: ['React', 'Hooks', '状态管理'],
    image: 'https://picsum.photos/400/250?random=8'
  },
  {
    id: 5,
    title: 'TypeScript 类型系统进阶',
    excerpt: '掌握 TypeScript 高级类型技巧，编写更安全的 JavaScript 代码。',
    category: 'TypeScript',
    date: '2023-12-15',
    readTime: '15分钟阅读',
    views: 2345,
    likes: 178,
    tags: ['TypeScript', '类型', '进阶'],
    image: 'https://picsum.photos/400/250?random=9'
  },
  {
    id: 6,
    title: 'Webpack 5 配置优化指南',
    excerpt: '学习 Webpack 5 的最新特性和优化技巧，提升构建性能。',
    category: '构建工具',
    date: '2023-12-10',
    readTime: '14分钟阅读',
    views: 1987,
    likes: 112,
    tags: ['Webpack', '构建', '优化'],
    image: 'https://picsum.photos/400/250?random=10'
  },
  {
    id: 7,
    title: '前端性能优化实战',
    excerpt: '实用的前端性能优化技巧，从加载到渲染的全方位优化方案。',
    category: '性能优化',
    date: '2023-12-05',
    readTime: '18分钟阅读',
    views: 3124,
    likes: 201,
    tags: ['性能', '优化', '实战'],
    image: 'https://picsum.photos/400/250?random=11'
  },
  {
    id: 8,
    title: 'Node.js 后端开发入门',
    excerpt: '从零开始学习 Node.js 后端开发，构建完整的 Web 应用。',
    category: 'Node.js',
    date: '2023-11-28',
    readTime: '20分钟阅读',
    views: 1765,
    likes: 98,
    tags: ['Node.js', '后端', '入门'],
    image: 'https://picsum.photos/400/250?random=12'
  },
  {
    id: 9,
    title: '移动端适配解决方案',
    excerpt: '全面的移动端适配方案，确保网站在各种设备上完美显示。',
    category: '响应式设计',
    date: '2023-11-20',
    readTime: '9分钟阅读',
    views: 2234,
    likes: 134,
    tags: ['移动端', '适配', '响应式'],
    image: 'https://picsum.photos/400/250?random=13'
  }
]

const categories = computed(() => {
  return [...new Set(blogPosts.map(post => post.category))]
})

const filteredPosts = computed(() => {
  let filtered = blogPosts.filter(post => {
    const matchesCategory = !selectedCategory.value || post.category === selectedCategory.value
    const matchesSearch = !searchQuery.value || 
      post.title.toLowerCase().includes(searchQuery.value.toLowerCase()) ||
      post.excerpt.toLowerCase().includes(searchQuery.value.toLowerCase()) ||
      post.tags.some(tag => tag.toLowerCase().includes(searchQuery.value.toLowerCase()))
    
    return matchesCategory && matchesSearch
  })

  // Sort posts
  filtered.sort((a, b) => {
    switch (sortBy.value) {
      case 'date':
        return new Date(b.date) - new Date(a.date)
      case 'views':
        return b.views - a.views
      case 'title':
        return a.title.localeCompare(b.title)
      default:
        return 0
    }
  })

  return filtered
})

const totalPages = computed(() => {
  return Math.ceil(filteredPosts.value.length / postsPerPage)
})

const paginatedPosts = computed(() => {
  const start = (currentPage.value - 1) * postsPerPage
  const end = start + postsPerPage
  return filteredPosts.value.slice(start, end)
})

const formatDate = (dateString) => {
  return new Date(dateString).toLocaleDateString('zh-CN', {
    year: 'numeric',
    month: 'long',
    day: 'numeric'
  })
}

// Reset to first page when filters change
onMounted(() => {
  currentPage.value = 1
})
</script>

<style scoped>
.blog-page {
  min-height: 100vh;
  background: #f8f9fa;
}

.page-header {
  background: linear-gradient(135deg, #2c3e50 0%, #34495e 100%);
  color: white;
  padding: 3rem 0;
  text-align: center;
}

.page-header h1 {
  font-size: 2.5rem;
  margin-bottom: 1rem;
}

.page-header p {
  font-size: 1.1rem;
  opacity: 0.9;
}

.blog-content {
  padding: 3rem 0;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
}

.filters {
  display: flex;
  gap: 2rem;
  margin-bottom: 3rem;
  align-items: center;
  flex-wrap: wrap;
}

.filter-group {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.filter-group label {
  font-weight: 500;
  color: #2c3e50;
}

.filter-select {
  padding: 0.5rem 1rem;
  border: 1px solid #e9ecef;
  border-radius: 0.5rem;
  background: white;
  color: #2c3e50;
  cursor: pointer;
}

.search-group {
  position: relative;
  flex: 1;
  max-width: 300px;
}

.search-input {
  width: 100%;
  padding: 0.5rem 1rem 0.5rem 2.5rem;
  border: 1px solid #e9ecef;
  border-radius: 0.5rem;
  font-size: 1rem;
}

.search-icon {
  position: absolute;
  left: 0.8rem;
  top: 50%;
  transform: translateY(-50%);
  color: #7f8c8d;
}

.blog-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
  gap: 2rem;
  margin-bottom: 3rem;
}

.blog-card {
  background: white;
  border-radius: 1rem;
  overflow: hidden;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.blog-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.15);
}

.card-image {
  position: relative;
  overflow: hidden;
  height: 200px;
}

.card-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.3s ease;
}

.blog-card:hover .card-image img {
  transform: scale(1.1);
}

.card-category {
  position: absolute;
  top: 1rem;
  left: 1rem;
  background: rgba(102, 126, 234, 0.9);
  color: white;
  padding: 0.5rem 1rem;
  border-radius: 2rem;
  font-size: 0.8rem;
  font-weight: 500;
}

.card-content {
  padding: 1.5rem;
}

.card-title {
  font-size: 1.3rem;
  font-weight: 600;
  color: #2c3e50;
  margin-bottom: 1rem;
  line-height: 1.4;
}

.card-excerpt {
  color: #7f8c8d;
  line-height: 1.6;
  margin-bottom: 1.5rem;
}

.card-meta {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1rem;
  font-size: 0.9rem;
  color: #95a5a6;
}

.meta-left,
.meta-right {
  display: flex;
  gap: 1rem;
  align-items: center;
}

.card-tags {
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
  margin-bottom: 1.5rem;
}

.tag {
  background: #f1f3f4;
  color: #5f6368;
  padding: 0.3rem 0.8rem;
  border-radius: 1rem;
  font-size: 0.8rem;
  font-weight: 500;
}

.card-link {
  color: #667eea;
  text-decoration: none;
  font-weight: 500;
  transition: color 0.3s ease;
  display: inline-block;
}

.card-link:hover {
  color: #764ba2;
}

.no-results {
  text-align: center;
  padding: 3rem;
  color: #7f8c8d;
}

.no-results h3 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
}

.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 2rem;
  margin-top: 2rem;
}

.pagination-btn {
  padding: 0.5rem 1.5rem;
  border: 1px solid #667eea;
  background: white;
  color: #667eea;
  border-radius: 0.5rem;
  cursor: pointer;
  transition: all 0.3s ease;
}

.pagination-btn:hover:not(:disabled) {
  background: #667eea;
  color: white;
}

.pagination-btn:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}

.pagination-info {
  color: #7f8c8d;
  font-weight: 500;
}

/* Responsive Design */
@media (max-width: 768px) {
  .filters {
    flex-direction: column;
    align-items: stretch;
    gap: 1rem;
  }

  .filter-group {
    justify-content: space-between;
  }

  .search-group {
    max-width: none;
  }

  .blog-grid {
    grid-template-columns: 1fr;
  }

  .card-meta {
    flex-direction: column;
    align-items: flex-start;
    gap: 0.5rem;
  }

  .pagination {
    flex-direction: column;
    gap: 1rem;
  }

  .page-header {
    padding: 2rem 0;
  }

  .page-header h1 {
    font-size: 2rem;
  }
}

@media (max-width: 480px) {
  .container {
    padding: 0 15px;
  }

  .blog-card {
    margin: 0 -15px;
    border-radius: 0;
  }

  .card-content {
    padding: 1rem;
  }

  .card-title {
    font-size: 1.1rem;
  }
}

/* Animations */
.blog-card {
  animation: fadeInUp 0.6s ease-out;
}

.blog-card:nth-child(1) { animation-delay: 0.1s; }
.blog-card:nth-child(2) { animation-delay: 0.2s; }
.blog-card:nth-child(3) { animation-delay: 0.3s; }
.blog-card:nth-child(4) { animation-delay: 0.4s; }
.blog-card:nth-child(5) { animation-delay: 0.5s; }
.blog-card:nth-child(6) { animation-delay: 0.6s; }

@keyframes fadeInUp {
  from {
    opacity: 0;
    transform: translateY(30px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}
</style>