<template>
  <div class="blog-detail">
    <div class="container">
      <!-- Back Button -->
      <button class="back-btn" @click="$router.push('/blog')">
        ← 返回博客列表
      </button>

      <!-- Article Header -->
      <header class="article-header">
        <div class="article-meta">
          <span class="category">{{ currentPost.category }}</span>
          <span class="date">{{ currentPost.date }}</span>
          <span class="read-time">{{ currentPost.readTime }} 分钟阅读</span>
        </div>
        <h1 class="article-title">{{ currentPost.title }}</h1>
        <div class="author-info">
          <img :src="currentPost.authorAvatar" :alt="currentPost.author" class="author-avatar" />
          <div class="author-details">
            <span class="author-name">{{ currentPost.author }}</span>
            <span class="author-bio">{{ currentPost.authorBio }}</span>
          </div>
        </div>
      </header>

      <!-- Featured Image -->
      <div class="featured-image">
        <img :src="currentPost.image" :alt="currentPost.title" />
      </div>

      <!-- Article Content -->
      <article class="article-content">
        <div class="content-wrapper">
          <!-- Introduction -->
          <section class="content-section">
            <h2>引言</h2>
            <p>在现代前端开发中，Vue3 的组合式 API 为我们提供了更灵活、更强大的代码组织方式。本文将深入探讨 Composition API 的核心概念、最佳实践以及常见的使用场景。</p>
          </section>

          <!-- Main Content -->
          <section class="content-section">
            <h2>核心概念解析</h2>
            <p>组合式 API 的核心思想是将相关的逻辑组织在一起，而不是按照选项（data、methods、computed 等）来分隔代码。这使得代码更加模块化和可复用。</p>
            
            <h3>1. setup() 函数</h3>
            <p>setup() 函数是组合式 API 的入口点，它在组件实例创建之前执行。在这里，我们可以定义响应式数据、计算属性、方法等。</p>
            
            <div class="code-block">
              <pre><code>import { ref, computed } from 'vue'

export default {
  setup() {
    const count = ref(0)
    const double = computed(() => count.value * 2)
    
    function increment() {
      count.value++
    }
    
    return {
      count,
      double,
      increment
    }
  }
}</code></pre>
            </div>

            <h3>2. 响应式引用 (ref)</h3>
            <p>ref() 用于创建响应式的数据引用，它可以包装任何类型的值，包括对象和数组。</p>
            
            <div class="code-block">
              <pre><code>import { ref } from 'vue'

const message = ref('Hello Vue3!')
const user = ref({
  name: 'John',
  age: 30
})

// 访问值
console.log(message.value) // 'Hello Vue3!'
console.log(user.value.name) // 'John'</code></pre>
            </div>

            <h3>3. 计算属性 (computed)</h3>
            <p>computed() 用于创建基于响应式数据的计算属性，当依赖的数据变化时，计算属性会自动更新。</p>
            
            <div class="code-block">
              <pre><code>import { ref, computed } from 'vue'

const price = ref(100)
const quantity = ref(2)

const total = computed(() => price.value * quantity.value)

console.log(total.value) // 200</code></pre>
            </div>
          </section>

          <!-- Best Practices -->
          <section class="content-section">
            <h2>最佳实践</h2>
            <p>在使用组合式 API 时，遵循一些最佳实践可以让代码更加清晰和可维护：</p>
            
            <ul>
              <li><strong>逻辑复用：</strong>将相关的逻辑提取到自定义组合函数中</li>
              <li><strong>命名规范：</strong>使用有意义的变量名和函数名</li>
              <li><strong>代码组织：</strong>按照功能而不是选项类型来组织代码</li>
              <li><strong>类型安全：</strong>结合 TypeScript 使用可以获得更好的类型提示</li>
            </ul>
            
            <div class="code-block">
              <pre><code>// 自定义组合函数示例
import { ref, onMounted, onUnmounted } from 'vue'

export function useMousePosition() {
  const x = ref(0)
  const y = ref(0)
  
  function update(event) {
    x.value = event.pageX
    y.value = event.pageY
  }
  
  onMounted(() => window.addEventListener('mousemove', update))
  onUnmounted(() => window.removeEventListener('mousemove', update))
  
  return { x, y }
}

// 在组件中使用
const { x, y } = useMousePosition()</code></pre>
            </div>
          </section>

          <!-- Conclusion -->
          <section class="content-section">
            <h2>总结</h2>
            <p>Vue3 的组合式 API 为我们提供了更灵活、更强大的代码组织方式。通过合理的代码组织和逻辑复用，我们可以创建出更加模块化、可维护的前端应用。</p>
            
            <p>记住，技术只是工具，最重要的是如何运用这些工具来解决实际问题。希望本文能帮助您更好地理解和使用 Vue3 的组合式 API。</p>
          </section>
        </div>

        <!-- Table of Contents -->
        <aside class="toc">
          <h3>目录</h3>
          <nav>
            <a href="#引言" class="toc-link">引言</a>
            <a href="#核心概念解析" class="toc-link">核心概念解析</a>
            <a href="#最佳实践" class="toc-link">最佳实践</a>
            <a href="#总结" class="toc-link">总结</a>
          </nav>
        </aside>
      </article>

      <!-- Article Footer -->
      <footer class="article-footer">
        <div class="stats">
          <span class="views">👁️ {{ currentPost.views }} 浏览</span>
          <span class="likes">❤️ {{ currentPost.likes }} 喜欢</span>
          <span class="comments">💬 42 评论</span>
        </div>
        
        <div class="tags">
          <span class="tag" v-for="tag in currentPost.tags" :key="tag">#{{ tag }}</span>
        </div>
        
        <div class="share">
          <button class="share-btn">分享文章</button>
        </div>
      </footer>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const postId = parseInt(route.params.id)

const blogPosts = ref([
  {
    id: 1,
    title: 'Vue3 组合式 API 深度解析',
    excerpt: '全面掌握 Vue3 Composition API 的核心概念和使用技巧，提升开发效率。',
    date: '2024-01-15',
    category: 'Vue',
    readTime: 8,
    author: '星辰',
    authorBio: '前端开发工程师，热爱技术分享',
    authorAvatar: 'https://picsum.photos/60/60?random=1',
    views: 1245,
    likes: 89,
    image: 'https://picsum.photos/800/400?random=11',
    tags: ['Vue3', 'Composition API', '前端', 'JavaScript']
  }
])

const currentPost = computed(() => {
  return blogPosts.value.find(post => post.id === postId) || blogPosts.value[0]
})
</script>

<style scoped>
.blog-detail {
  padding: 2rem 0;
  min-height: 100vh;
}

.container {
  max-width: 1000px;
  margin: 0 auto;
  padding: 0 20px;
}

.back-btn {
  background: none;
  border: none;
  color: #667eea;
  font-size: 1rem;
  cursor: pointer;
  padding: 0.5rem 1rem;
  border-radius: 20px;
  transition: all 0.3s ease;
  margin-bottom: 2rem;
}

.back-btn:hover {
  background: #f8f9fa;
  transform: translateX(-5px);
}

.article-header {
  text-align: center;
  margin-bottom: 3rem;
}

.article-meta {
  display: flex;
  justify-content: center;
  gap: 1rem;
  margin-bottom: 1rem;
  font-size: 0.9rem;
  color: #95a5a6;
}

.category {
  background: #667eea;
  color: white;
  padding: 0.3rem 0.8rem;
  border-radius: 15px;
  font-weight: 500;
}

.article-title {
  font-size: 2.5rem;
  font-weight: 700;
  line-height: 1.3;
  color: #2c3e50;
  margin-bottom: 2rem;
}

.author-info {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 1rem;
}

.author-avatar {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  object-fit: cover;
}

.author-details {
  text-align: left;
}

.author-name {
  display: block;
  font-weight: 600;
  color: #2c3e50;
}

.author-bio {
  font-size: 0.9rem;
  color: #7f8c8d;
}

.featured-image {
  margin-bottom: 3rem;
  border-radius: 20px;
  overflow: hidden;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

.featured-image img {
  width: 100%;
  height: 400px;
  object-fit: cover;
}

.article-content {
  display: grid;
  grid-template-columns: 1fr 300px;
  gap: 3rem;
  margin-bottom: 3rem;
}

.content-wrapper {
  max-width: 700px;
}

.content-section {
  margin-bottom: 3rem;
}

.content-section h2 {
  font-size: 1.8rem;
  color: #2c3e50;
  margin-bottom: 1.5rem;
  padding-bottom: 0.5rem;
  border-bottom: 2px solid #ecf0f1;
}

.content-section h3 {
  font-size: 1.3rem;
  color: #34495e;
  margin: 1.5rem 0 1rem;
}

.content-section p {
  line-height: 1.8;
  color: #2c3e50;
  margin-bottom: 1.5rem;
}

.content-section ul {
  margin: 1.5rem 0;
  padding-left: 2rem;
}

.content-section li {
  line-height: 1.8;
  color: #2c3e50;
  margin-bottom: 0.5rem;
}

.code-block {
  background: #2d3748;
  border-radius: 10px;
  overflow: hidden;
  margin: 1.5rem 0;
}

.code-block pre {
  margin: 0;
  padding: 1.5rem;
  overflow-x: auto;
}

.code-block code {
  color: #e2e8f0;
  font-family: 'Monaco', 'Menlo', 'Ubuntu Mono', monospace;
  font-size: 0.9rem;
  line-height: 1.5;
}

.toc {
  position: sticky;
  top: 100px;
  align-self: start;
  background: white;
  padding: 1.5rem;
  border-radius: 15px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
}

.toc h3 {
  color: #2c3e50;
  margin-bottom: 1rem;
  font-size: 1.2rem;
}

.toc nav {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.toc-link {
  color: #667eea;
  text-decoration: none;
  padding: 0.5rem 0;
  transition: color 0.3s ease;
  border-left: 3px solid transparent;
  padding-left: 0.5rem;
}

.toc-link:hover {
  color: #764ba2;
  border-left-color: #667eea;
}

.article-footer {
  border-top: 1px solid #ecf0f1;
  padding-top: 2rem;
}

.stats {
  display: flex;
  gap: 2rem;
  margin-bottom: 1.5rem;
  color: #95a5a6;
  font-size: 0.9rem;
}

.tags {
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
  margin-bottom: 1.5rem;
}

.tag {
  background: #ecf0f1;
  color: #667eea;
  padding: 0.3rem 0.8rem;
  border-radius: 15px;
  font-size: 0.9rem;
  font-weight: 500;
}

.share-btn {
  background: linear-gradient(45deg, #667eea, #764ba2);
  color: white;
  border: none;
  padding: 0.8rem 1.5rem;
  border-radius: 25px;
  cursor: pointer;
  font-weight: 500;
  transition: all 0.3s ease;
}

.share-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 15px rgba(102, 126, 234, 0.3);
}

@media (max-width: 968px) {
  .article-content {
    grid-template-columns: 1fr;
    gap: 2rem;
  }
  
  .toc {
    position: static;
    order: -1;
  }
  
  .article-title {
    font-size: 2rem;
  }
  
  .featured-image img {
    height: 300px;
  }
}

@media (max-width: 768px) {
  .article-meta {
    flex-direction: column;
    align-items: center;
    gap: 0.5rem;
  }
  
  .stats {
    flex-direction: column;
    gap: 0.5rem;
  }
  
  .article-title {
    font-size: 1.8rem;
  }
  
  .content-section h2 {
    font-size: 1.5rem;
  }
}
</style>