<template>
  <footer class="footer">
    <div class="footer-container">
      <!-- Main Footer Content -->
      <div class="footer-content">
        <!-- Brand Section -->
        <div class="footer-section">
          <h3 class="footer-title">星辰博客</h3>
          <p class="footer-description">
            分享前端技术、生活感悟和创意想法。记录成长，分享知识。
          </p>
          <div class="social-links">
            <a 
              href="#" 
              class="social-link"
              aria-label="GitHub"
            >
              <span class="social-icon">🐱</span>
            </a>
            <a 
              href="#" 
              class="social-link"
              aria-label="Twitter"
            >
              <span class="social-icon">🐦</span>
            </a>
            <a 
              href="#" 
              class="social-link"
              aria-label="LinkedIn"
            >
              <span class="social-icon">💼</span>
            </a>
            <a 
              href="#" 
              class="social-link"
              aria-label="Email"
            >
              <span class="social-icon">📧</span>
            </a>
          </div>
        </div>

        <!-- Quick Links -->
        <div class="footer-section">
          <h4 class="footer-subtitle">快速链接</h4>
          <ul class="footer-links">
            <li>
              <router-link to="/" class="footer-link">首页</router-link>
            </li>
            <li>
              <router-link to="/blog" class="footer-link">博客文章</router-link>
            </li>
            <li>
              <router-link to="/about" class="footer-link">关于我</router-link>
            </li>
          </ul>
        </div>

        <!-- Categories -->
        <div class="footer-section">
          <h4 class="footer-subtitle">文章分类</h4>
          <ul class="footer-links">
            <li><a href="#" class="footer-link">前端开发</a></li>
            <li><a href="#" class="footer-link">JavaScript</a></li>
            <li><a href="#" class="footer-link">Vue.js</a></li>
            <li><a href="#" class="footer-link">React</a></li>
            <li><a href="#" class="footer-link">CSS/设计</a></li>
            <li><a href="#" class="footer-link">工具推荐</a></li>
          </ul>
        </div>

        <!-- Contact Info -->
        <div class="footer-section">
          <h4 class="footer-subtitle">联系信息</h4>
          <div class="contact-info">
            <div class="contact-item">
              <span class="contact-icon">📧</span>
              <span>contact@chenxing.com</span>
            </div>
            <div class="contact-item">
              <span class="contact-icon">🌐</span>
              <span>www.chenxingblog.com</span>
            </div>
            <div class="contact-item">
              <span class="contact-icon">📍</span>
              <span>中国 · 北京</span>
            </div>
          </div>
        </div>
      </div>

      <!-- Footer Bottom -->
      <div class="footer-bottom">
        <div class="footer-bottom-content">
          <p class="copyright">
            © 2024 星辰博客. 保留所有权利.
          </p>
          <div class="footer-bottom-links">
            <a href="#" class="footer-bottom-link">隐私政策</a>
            <span class="separator">|</span>
            <a href="#" class="footer-bottom-link">服务条款</a>
            <span class="separator">|</span>
            <a href="#" class="footer-bottom-link">网站地图</a>
          </div>
        </div>
      </div>
    </div>
  </footer>
</template>

<style scoped>
.footer {
  background: linear-gradient(135deg, #2c3e50 0%, #34495e 100%);
  color: white;
  margin-top: auto;
}

.footer-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
}

.footer-content {
  display: grid;
  grid-template-columns: 2fr 1fr 1fr 1.5fr;
  gap: 3rem;
  padding: 3rem 0 2rem;
}

.footer-section h3,
.footer-section h4 {
  color: white;
  margin-bottom: 1.5rem;
}

.footer-title {
  font-size: 1.8rem;
  font-weight: 700;
  background: linear-gradient(45deg, #667eea, #764ba2);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
  margin-bottom: 1rem;
}

.footer-description {
  color: #bdc3c7;
  line-height: 1.6;
  margin-bottom: 2rem;
}

.social-links {
  display: flex;
  gap: 1rem;
}

.social-link {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 45px;
  height: 45px;
  background: rgba(255, 255, 255, 0.1);
  border-radius: 50%;
  transition: all 0.3s ease;
  text-decoration: none;
}

.social-link:hover {
  background: linear-gradient(45deg, #667eea, #764ba2);
  transform: translateY(-2px);
}

.social-icon {
  font-size: 1.2rem;
}

.footer-subtitle {
  font-size: 1.2rem;
  font-weight: 600;
  color: #ecf0f1;
}

.footer-links {
  list-style: none;
}

.footer-links li {
  margin-bottom: 0.8rem;
}

.footer-link {
  color: #bdc3c7;
  text-decoration: none;
  transition: color 0.3s ease;
  font-size: 0.95rem;
}

.footer-link:hover {
  color: #667eea;
}

.contact-info {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.contact-item {
  display: flex;
  align-items: center;
  gap: 0.8rem;
  color: #bdc3c7;
  font-size: 0.95rem;
}

.contact-icon {
  font-size: 1.1rem;
}

.footer-bottom {
  border-top: 1px solid rgba(255, 255, 255, 0.1);
  padding: 1.5rem 0;
}

.footer-bottom-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  gap: 1rem;
}

.copyright {
  color: #95a5a6;
  font-size: 0.9rem;
}

.footer-bottom-links {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.footer-bottom-link {
  color: #95a5a6;
  text-decoration: none;
  font-size: 0.9rem;
  transition: color 0.3s ease;
}

.footer-bottom-link:hover {
  color: #667eea;
}

.separator {
  color: #7f8c8d;
}

/* Responsive design */
@media (max-width: 968px) {
  .footer-content {
    grid-template-columns: 1fr 1fr;
    gap: 2rem;
  }
}

@media (max-width: 768px) {
  .footer-content {
    grid-template-columns: 1fr;
    gap: 2rem;
    text-align: center;
  }

  .social-links {
    justify-content: center;
  }

  .footer-bottom-content {
    flex-direction: column;
    text-align: center;
  }

  .footer-bottom-links {
    justify-content: center;
  }

  .contact-item {
    justify-content: center;
  }
}

@media (max-width: 480px) {
  .footer-container {
    padding: 0 15px;
  }

  .footer-content {
    padding: 2rem 0 1.5rem;
  }

  .footer-bottom-links {
    flex-wrap: wrap;
    justify-content: center;
  }

  .separator {
    display: none;
  }

  .footer-bottom-link {
    margin: 0 0.5rem;
  }
}

/* Animation for social links */
.social-link {
  position: relative;
  overflow: hidden;
}

.social-link::before {
  content: '';
  position: absolute;
  top: 0;
  left: -100%;
  width: 100%;
  height: 100%;
  background: linear-gradient(90deg, transparent, rgba(255, 255, 255, 0.2), transparent);
  transition: left 0.5s ease;
}

.social-link:hover::before {
  left: 100%;
}
</style>