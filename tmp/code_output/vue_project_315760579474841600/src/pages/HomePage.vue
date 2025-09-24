<template>
  <div class="home-page">
    <!-- Hero Section -->
    <section class="hero-section">
      <div class="hero-container">
        <div class="hero-content">
          <h1 class="hero-title">
            探索前端技术的
            <span class="gradient-text">无限可能</span>
          </h1>
          <p class="hero-description">
            欢迎来到星辰博客，这里是我分享前端开发经验、技术心得和生活感悟的地方。
            从基础到进阶，从理论到实践，让我们一起在技术的海洋中探索前行。
          </p>
          <div class="hero-actions">
            <router-link to="/blog" class="btn btn-primary">
              阅读博客
            </router-link>
            <router-link to="/about" class="btn btn-secondary">
              关于作者
            </router-link>
          </div>
        </div>
        <div class="hero-image">
          <img 
            src="https://picsum.photos/600/400?random=1" 
            alt="技术博客封面"
            loading="lazy"
          />
        </div>
      </div>
    </section>

    <!-- Featured Posts -->
    <section class="featured-section">
      <div class="container">
        <div class="section-header">
          <h2>精选文章</h2>
          <p>最近更新的高质量技术文章</p>
        </div>
        <div class="featured-grid">
          <article 
            v-for="post in featuredPosts" 
            :key="post.id"
            class="featured-card"
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
              <h3 class="card-title">{{ post.title }}</h3>
              <p class="card-excerpt">{{ post.excerpt }}</p>
              <div class="card-meta">
                <span class="meta-date">{{ post.date }}</span>
                <span class="meta-read-time">{{ post.readTime }}</span>
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
      </div>
    </section>

    <!-- Stats Section -->
    <section class="stats-section">
      <div class="container">
        <div class="stats-grid">
          <div class="stat-item">
            <div class="stat-number">128</div>
            <div class="stat-label">技术文章</div>
          </div>
          <div class="stat-item">
            <div class="stat-number">15K+</div>
            <div class="stat-label">阅读量</div>
          </div>
          <div class="stat-item">
            <div class="stat-number">3</div>
            <div class="stat-label">年经验</div>
          </div>
          <div class="stat-item">
            <div class="stat-number">42</div>
            <div class="stat-label">项目实战</div>
          </div>
        </div>
      </div>
    </section>

    <!-- Categories Section -->
    <section class="categories-section">
      <div class="container">
        <div class="section-header">
          <h2>热门分类</h2>
          <p>探索不同技术领域的内容</p>
        </div>
        <div class="categories-grid">
          <div 
            v-for="category in categories" 
            :key="category.name"
            class="category-card"
          >
            <div class="category-icon">{{ category.icon }}</div>
            <h3>{{ category.name }}</h3>
            <p>{{ category.description }}</p>
            <span class="category-count">{{ category.count }} 篇文章</span>
          </div>
        </div>
      </div>
    </section>

    <!-- Newsletter Section -->
    <section class="newsletter-section">
      <div class="container">
        <div class="newsletter-content">
          <h2>订阅更新</h2>
          <p>获取最新的技术文章和开发技巧，直接发送到您的邮箱</p>
          <form @submit.prevent="subscribeNewsletter" class="newsletter-form">
            <input
              type="email"
              v-model="email"
              placeholder="请输入您的邮箱地址"
              required
              class="form-input"
            />
            <button type="submit" class="btn btn-primary">
              订阅
            </button>
          </form>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const email = ref('')

const featuredPosts = [
  {
    id: 1,
    title: 'Vue 3 Composition API 最佳实践',
    excerpt: '深入探讨 Vue 3 Composition API 的使用技巧和最佳实践，帮助您写出更优雅的代码。',
    category: 'Vue.js',
    date: '2024-01-15',
    readTime: '8分钟阅读',
    image: 'https://picsum.photos/400/250?random=2'
  },
  {
    id: 2,
    title: 'JavaScript 异步编程完全指南',
    excerpt: '从回调函数到 async/await，全面解析 JavaScript 异步编程的各种模式和技巧。',
    category: 'JavaScript',
    date: '2024-01-10',
    readTime: '12分钟阅读',
    image: 'https://picsum.photos/400/250?random=3'
  },
  {
    id: 3,
    title: 'CSS Grid 布局实战教程',
    excerpt: '通过实际案例学习 CSS Grid 布局的强大功能，创建复杂的响应式页面布局。',
    category: 'CSS',
    date: '2024-01-05',
    readTime: '6分钟阅读',
    image: 'https://picsum.photos/400/250?random=4'
  }
]

const categories = [
  {
    name: '前端开发',
    icon: '💻',
    description: 'Web 前端技术栈和开发实践',
    count: 45
  },
  {
    name: 'JavaScript',
    icon: '📜',
    description: 'JavaScript 语言特性和高级用法',
    count: 32
  },
  {
    name: 'Vue.js',
    icon: '🟢',
    description: 'Vue.js 框架深入解析',
    count: 28
  },
  {
    name: 'React',
    icon: '⚛️',
    description: 'React 生态和技术实践',
    count: 15
  },
  {
    name: 'CSS/设计',
    icon: '🎨',
    description: 'CSS 技巧和 UI 设计',
    count: 18
  },
  {
    name: '工具推荐',
    icon: '🛠️',
    description: '开发工具和效率提升',
    count: 22
  }
]

const subscribeNewsletter = () => {
  if (email.value) {
    alert(`感谢订阅！我们将发送更新到: ${email.value}`)
    email.value = ''
  }
}
</script>

<style scoped>
.home-page {
  min-height: 100vh;
}

/* Hero Section */
.hero-section {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  padding: 4rem 0;
}

.hero-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 4rem;
  align-items: center;
}

.hero-title {
  font-size: 3.5rem;
  font-weight: 700;
  line-height: 1.2;
  margin-bottom: 1.5rem;
}

.gradient-text {
  background: linear-gradient(45deg, #ffd89b, #19547b);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.hero-description {
  font-size: 1.2rem;
  line-height: 1.6;
  margin-bottom: 2rem;
  opacity: 0.9;
}

.hero-actions {
  display: flex;
  gap: 1rem;
  flex-wrap: wrap;
}

.hero-image {
  border-radius: 1rem;
  overflow: hidden;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
}

.hero-image img {
  width: 100%;
  height: auto;
  display: block;
  transition: transform 0.3s ease;
}

.hero-image:hover img {
  transform: scale(1.05);
}

/* Section Header */
.section-header {
  text-align: center;
  margin-bottom: 3rem;
}

.section-header h2 {
  font-size: 2.5rem;
  color: #2c3e50;
  margin-bottom: 1rem;
}

.section-header p {
  font-size: 1.1rem;
  color: #7f8c8d;
}

/* Featured Posts */
.featured-section {
  padding: 5rem 0;
  background: white;
}

.featured-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
  gap: 2rem;
}

.featured-card {
  background: white;
  border-radius: 1rem;
  overflow: hidden;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.featured-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.15);
}

.card-image {
  position: relative;
  overflow: hidden;
}

.card-image img {
  width: 100%;
  height: 200px;
  object-fit: cover;
  transition: transform 0.3s ease;
}

.featured-card:hover .card-image img {
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
  margin-bottom: 1rem;
}

.card-meta {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1rem;
  font-size: 0.9rem;
  color: #95a5a6;
}

.card-link {
  color: #667eea;
  text-decoration: none;
  font-weight: 500;
  transition: color 0.3s ease;
}

.card-link:hover {
  color: #764ba2;
}

/* Stats Section */
.stats-section {
  background: linear-gradient(135deg, #2c3e50 0%, #34495e 100%);
  color: white;
  padding: 4rem 0;
}

.stats-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 2rem;
  text-align: center;
}

.stat-item {
  padding: 2rem;
}

.stat-number {
  font-size: 3rem;
  font-weight: 700;
  background: linear-gradient(45deg, #667eea, #764ba2);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
  margin-bottom: 0.5rem;
}

.stat-label {
  font-size: 1.1rem;
  color: #bdc3c7;
}

/* Categories Section */
.categories-section {
  padding: 5rem 0;
  background: #f8f9fa;
}

.categories-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
  gap: 2rem;
}

.category-card {
  background: white;
  padding: 2rem;
  border-radius: 1rem;
  text-align: center;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.08);
  transition: transform 0.3s ease;
}

.category-card:hover {
  transform: translateY(-3px);
}

.category-icon {
  font-size: 3rem;
  margin-bottom: 1rem;
}

.category-card h3 {
  font-size: 1.3rem;
  color: #2c3e50;
  margin-bottom: 1rem;
}

.category-card p {
  color: #7f8c8d;
  margin-bottom: 1rem;
  line-height: 1.6;
}

.category-count {
  color: #667eea;
  font-weight: 500;
}

/* Newsletter Section */
.newsletter-section {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  padding: 4rem 0;
}

.newsletter-content {
  max-width: 600px;
  margin: 0 auto;
  text-align: center;
}

.newsletter-content h2 {
  font-size: 2.5rem;
  margin-bottom: 1rem;
}

.newsletter-content p {
  font-size: 1.1rem;
  margin-bottom: 2rem;
  opacity: 0.9;
}

.newsletter-form {
  display: flex;
  gap: 1rem;
  max-width: 400px;
  margin: 0 auto;
}

.newsletter-form .form-input {
  flex: 1;
  padding: 1rem;
  border: none;
  border-radius: 0.5rem;
  font-size: 1rem;
}

/* Responsive Design */
@media (max-width: 968px) {
  .hero-container {
    grid-template-columns: 1fr;
    gap: 2rem;
    text-align: center;
  }

  .hero-title {
    font-size: 2.5rem;
  }

  .stats-grid {
    grid-template-columns: repeat(2, 1fr);
  }

  .newsletter-form {
    flex-direction: column;
  }
}

@media (max-width: 768px) {
  .hero-section {
    padding: 3rem 0;
  }

  .hero-title {
    font-size: 2rem;
  }

  .hero-actions {
    justify-content: center;
  }

  .featured-grid {
    grid-template-columns: 1fr;
  }

  .stats-grid {
    grid-template-columns: 1fr;
    gap: 1.5rem;
  }

  .stat-number {
    font-size: 2.5rem;
  }

  .categories-grid {
    grid-template-columns: 1fr;
  }

  .section-header h2 {
    font-size: 2rem;
  }
}

@media (max-width: 480px) {
  .hero-container {
    padding: 0 15px;
  }

  .hero-title {
    font-size: 1.8rem;
  }

  .hero-description {
    font-size: 1rem;
  }

  .featured-card {
    margin: 0 -15px;
    border-radius: 0;
  }

  .card-content {
    padding: 1rem;
  }
}

/* Animations */
.hero-content {
  animation: fadeInUp 0.8s ease-out;
}

.hero-image {
  animation: fadeIn 1s ease-out 0.2s both;
}

.featured-card {
  animation: fadeInUp 0.6s ease-out;
}

.featured-card:nth-child(1) { animation-delay: 0.1s; }
.featured-card:nth-child(2) { animation-delay: 0.2s; }
.featured-card:nth-child(3) { animation-delay: 0.3s; }

.category-card {
  animation: fadeInUp 0.6s ease-out;
}

.category-card:nth-child(1) { animation-delay: 0.1s; }
.category-card:nth-child(2) { animation-delay: 0.2s; }
.category-card:nth-child(3) { animation-delay: 0.3s; }
.category-card:nth-child(4) { animation-delay: 0.4s; }
.category-card:nth-child(5) { animation-delay: 0.5s; }
.category-card:nth-child(6) { animation-delay: 0.6s; }

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

@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}
</style>