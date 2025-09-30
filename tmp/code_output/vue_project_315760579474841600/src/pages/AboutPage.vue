<template>
  <div class="about-page">
    <div class="container">
      <!-- Hero Section -->
      <section class="hero-section">
        <div class="hero-content">
          <h1>关于我</h1>
          <p class="hero-subtitle">一名热爱技术的前端开发者</p>
          <p class="hero-description">
            专注于创造优雅、高效的 web 应用，热衷于探索新技术和分享知识。
          </p>
        </div>
        <div class="hero-image">
          <img src="https://picsum.photos/400/400?random=101" alt="个人头像" />
        </div>
      </section>

      <!-- Bio Section -->
      <section class="bio-section">
        <h2>个人简介</h2>
        <div class="bio-content">
          <p>
            你好！我是星辰，一名有着 5 年经验的前端开发工程师。我毕业于某知名大学计算机科学专业，
            毕业后一直致力于前端技术的研究和实践。
          </p>
          <p>
            我热爱编程，享受将创意转化为现实的过程。在日常工作中，我专注于 Vue、React 等现代前端框架，
            同时也对用户体验设计和性能优化有着浓厚的兴趣。
          </p>
          <p>
            除了技术工作，我还喜欢通过写作来分享知识和经验。这个博客就是我记录学习历程、
            分享技术见解的平台。希望我的文章能够对你有所帮助！
          </p>
        </div>
      </section>

      <!-- Skills Section -->
      <section class="skills-section">
        <h2>技术栈</h2>
        <div class="skills-grid">
          <div class="skill-category">
            <h3>前端技术</h3>
            <div class="skill-list">
              <span class="skill-tag">Vue.js</span>
              <span class="skill-tag">React</span>
              <span class="skill-tag">TypeScript</span>
              <span class="skill-tag">JavaScript</span>
              <span class="skill-tag">HTML5/CSS3</span>
              <span class="skill-tag">Sass/Less</span>
              <span class="skill-tag">Webpack</span>
              <span class="skill-tag">Vite</span>
            </div>
          </div>
          
          <div class="skill-category">
            <h3>后端技术</h3>
            <div class="skill-list">
              <span class="skill-tag">Node.js</span>
              <span class="skill-tag">Express</span>
              <span class="skill-tag">MongoDB</span>
              <span class="skill-tag">MySQL</span>
              <span class="skill-tag">Redis</span>
              <span class="skill-tag">RESTful API</span>
            </div>
          </div>
          
          <div class="skill-category">
            <h3>工具 & 其他</h3>
            <div class="skill-list">
              <span class="skill-tag">Git</span>
              <span class="skill-tag">Docker</span>
              <span class="skill-tag">AWS</span>
              <span class="skill-tag">Linux</span>
              <span class="skill-tag">Figma</span>
              <span class="skill-tag">Photoshop</span>
            </div>
          </div>
        </div>
      </section>

      <!-- Experience Section -->
      <section class="experience-section">
        <h2>工作经历</h2>
        <div class="timeline">
          <div class="timeline-item">
            <div class="timeline-content">
              <h3>高级前端开发工程师</h3>
              <span class="company">某科技公司</span>
              <span class="duration">2022年 - 至今</span>
              <p>负责核心产品的前端架构设计和开发，带领团队完成多个重要项目。</p>
              <ul>
                <li>主导了从 Vue2 到 Vue3 的技术迁移</li>
                <li>优化了前端构建流程，构建时间减少 40%</li>
                <li>引入了微前端架构，提升了团队协作效率</li>
              </ul>
            </div>
          </div>
          
          <div class="timeline-item">
            <div class="timeline-content">
              <h3>前端开发工程师</h3>
              <span class="company">某互联网公司</span>
              <span class="duration">2020年 - 2022年</span>
              <p>参与电商平台的前端开发，负责用户界面和交互体验的优化。</p>
              <ul>
                <li>开发了响应式电商网站，支持多端访问</li>
                <li>实现了前端性能监控系统</li>
                <li>参与了组件库的设计和开发</li>
              </ul>
            </div>
          </div>
          
          <div class="timeline-item">
            <div class="timeline-content">
              <h3>初级前端开发工程师</h3>
              <span class="company">某创业公司</span>
              <span class="duration">2019年 - 2020年</span>
              <p>开始前端开发职业生涯，参与多个项目的开发和维护。</p>
              <ul>
                <li>学习了现代前端开发技术栈</li>
                <li>参与了公司官网和后台管理系统的开发</li>
                <li>积累了丰富的实战经验</li>
              </ul>
            </div>
          </div>
        </div>
      </section>

      <!-- Contact Section -->
      <section class="contact-section">
        <h2>联系我</h2>
        <div class="contact-content">
          <p>如果你对我的工作感兴趣，或者有任何技术问题想要讨论，欢迎通过以下方式联系我：</p>
          
          <div class="contact-methods">
            <div class="contact-item">
              <div class="contact-icon">📧</div>
              <div class="contact-info">
                <h4>邮箱</h4>
                <p>contact@chenxing.com</p>
              </div>
            </div>
            
            <div class="contact-item">
              <div class="contact-icon">💼</div>
              <div class="contact-info">
                <h4>LinkedIn</h4>
                <p>linkedin.com/in/chenxing</p>
              </div>
            </div>
            
            <div class="contact-item">
              <div class="contact-icon">🐱</div>
              <div class="contact-info">
                <h4>GitHub</h4>
                <p>github.com/chenxing</p>
              </div>
            </div>
            
            <div class="contact-item">
              <div class="contact-icon">🐦</div>
              <div class="contact-info">
                <h4>Twitter</h4>
                <p>twitter.com/chenxing_dev</p>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  </div>
</template>

<style scoped>
.about-page {
  padding: 2rem 0;
  min-height: 100vh;
}

.container {
  max-width: 1000px;
  margin: 0 auto;
  padding: 0 20px;
}

.hero-section {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 4rem;
  align-items: center;
  margin-bottom: 4rem;
  padding: 3rem 0;
}

.hero-content h1 {
  font-size: 3rem;
  color: #2c3e50;
  margin-bottom: 1rem;
  font-weight: 700;
}

.hero-subtitle {
  font-size: 1.3rem;
  color: #667eea;
  margin-bottom: 1rem;
  font-weight: 600;
}

.hero-description {
  font-size: 1.1rem;
  color: #7f8c8d;
  line-height: 1.6;
}

.hero-image {
  display: flex;
  justify-content: center;
}

.hero-image img {
  width: 300px;
  height: 300px;
  border-radius: 50%;
  object-fit: cover;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
}

.bio-section {
  margin-bottom: 4rem;
}

.bio-section h2 {
  font-size: 2rem;
  color: #2c3e50;
  margin-bottom: 2rem;
  text-align: center;
}

.bio-content {
  max-width: 800px;
  margin: 0 auto;
}

.bio-content p {
  font-size: 1.1rem;
  line-height: 1.8;
  color: #2c3e50;
  margin-bottom: 1.5rem;
  text-align: justify;
}

.skills-section {
  margin-bottom: 4rem;
}

.skills-section h2 {
  font-size: 2rem;
  color: #2c3e50;
  margin-bottom: 2rem;
  text-align: center;
}

.skills-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 2rem;
}

.skill-category {
  background: white;
  padding: 2rem;
  border-radius: 20px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

.skill-category h3 {
  color: #667eea;
  margin-bottom: 1.5rem;
  font-size: 1.3rem;
}

.skill-list {
  display: flex;
  flex-wrap: wrap;
  gap: 0.8rem;
}

.skill-tag {
  background: linear-gradient(45deg, #667eea, #764ba2);
  color: white;
  padding: 0.5rem 1rem;
  border-radius: 20px;
  font-size: 0.9rem;
  font-weight: 500;
}

.experience-section {
  margin-bottom: 4rem;
}

.experience-section h2 {
  font-size: 2rem;
  color: #2c3e50;
  margin-bottom: 2rem;
  text-align: center;
}

.timeline {
  position: relative;
  max-width: 800px;
  margin: 0 auto;
}

.timeline::before {
  content: '';
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  width: 2px;
  height: 100%;
  background: linear-gradient(to bottom, #667eea, #764ba2);
}

.timeline-item {
  position: relative;
  margin-bottom: 3rem;
}

.timeline-item::before {
  content: '';
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  width: 12px;
  height: 12px;
  background: #667eea;
  border-radius: 50%;
  border: 3px solid white;
  box-shadow: 0 0 0 3px #667eea;
}

.timeline-content {
  background: white;
  padding: 2rem;
  border-radius: 15px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  width: calc(50% - 40px);
  margin-left: auto;
  position: relative;
}

.timeline-item:nth-child(even) .timeline-content {
  margin-left: 0;
  margin-right: auto;
}

.timeline-content h3 {
  color: #2c3e50;
  margin-bottom: 0.5rem;
  font-size: 1.2rem;
}

.company {
  display: block;
  color: #667eea;
  font-weight: 600;
  margin-bottom: 0.5rem;
}

.duration {
  display: block;
  color: #95a5a6;
  font-size: 0.9rem;
  margin-bottom: 1rem;
}

.timeline-content p {
  color: #2c3e50;
  line-height: 1.6;
  margin-bottom: 1rem;
}

.timeline-content ul {
  list-style: disc;
  padding-left: 1.5rem;
  color: #2c3e50;
}

.timeline-content li {
  margin-bottom: 0.5rem;
  line-height: 1.6;
}

.contact-section {
  margin-bottom: 4rem;
}

.contact-section h2 {
  font-size: 2rem;
  color: #2c3e50;
  margin-bottom: 2rem;
  text-align: center;
}

.contact-content {
  max-width: 600px;
  margin: 0 auto;
  text-align: center;
}

.contact-content p {
  font-size: 1.1rem;
  color: #7f8c8d;
  margin-bottom: 2rem;
  line-height: 1.6;
}

.contact-methods {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 2rem;
}

.contact-item {
  display: flex;
  align-items: center;
  gap: 1rem;
  padding: 1.5rem;
  background: white;
  border-radius: 15px;
  box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease;
}

.contact-item:hover {
  transform: translateY(-5px);
}

.contact-icon {
  font-size: 2rem;
}

.contact-info h4 {
  color: #2c3e50;
  margin-bottom: 0.5rem;
  font-size: 1.1rem;
}

.contact-info p {
  color: #667eea;
  font-weight: 500;
  margin: 0;
}

@media (max-width: 968px) {
  .hero-section {
    grid-template-columns: 1fr;
    text-align: center;
    gap: 2rem;
  }
  
  .hero-content h1 {
    font-size: 2.5rem;
  }
  
  .timeline::before {
    left: 20px;
  }
  
  .timeline-item::before {
    left: 20px;
  }
  
  .timeline-content {
    width: calc(100% - 60px);
    margin-left: 60px !important;
    margin-right: 0 !important;
  }
}

@media (max-width: 768px) {
  .hero-content h1 {
    font-size: 2rem;
  }
  
  .skills-grid {
    grid-template-columns: 1fr;
  }
  
  .contact-methods {
    grid-template-columns: 1fr;
  }
  
  .contact-item {
    flex-direction: column;
    text-align: center;
  }
  
  .bio-content p {
    text-align: left;
  }
}
</style>