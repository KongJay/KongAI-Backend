<template>
  <nav class="navbar">
    <div class="nav-container">
      <!-- Logo -->
      <router-link to="/" class="nav-logo">
        <span class="logo-text">星辰博客</span>
      </router-link>

      <!-- Desktop Navigation -->
      <div class="nav-menu">
        <router-link 
          to="/" 
          class="nav-link"
          :class="{ active: $route.path === '/' }"
        >
          首页
        </router-link>
        <router-link 
          to="/blog" 
          class="nav-link"
          :class="{ active: $route.path === '/blog' }"
        >
          博客
        </router-link>
        <router-link 
          to="/about" 
          class="nav-link"
          :class="{ active: $route.path === '/about' }"
        >
          关于
        </router-link>
      </div>

      <!-- Mobile menu button -->
      <div class="mobile-menu-btn" @click="toggleMobileMenu">
        <span></span>
        <span></span>
        <span></span>
      </div>
    </div>

    <!-- Mobile Navigation -->
    <transition name="slide-down">
      <div v-if="isMobileMenuOpen" class="mobile-menu">
        <router-link 
          to="/" 
          class="mobile-nav-link"
          :class="{ active: $route.path === '/' }"
          @click="closeMobileMenu"
        >
          首页
        </router-link>
        <router-link 
          to="/blog" 
          class="mobile-nav-link"
          :class="{ active: $route.path === '/blog' }"
          @click="closeMobileMenu"
        >
          博客
        </router-link>
        <router-link 
          to="/about" 
          class="mobile-nav-link"
          :class="{ active: $route.path === '/about' }"
          @click="closeMobileMenu"
        >
          关于
        </router-link>
      </div>
    </transition>
  </nav>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue'

const isMobileMenuOpen = ref(false)

const toggleMobileMenu = () => {
  isMobileMenuOpen.value = !isMobileMenuOpen.value
}

const closeMobileMenu = () => {
  isMobileMenuOpen.value = false
}

// Close mobile menu when clicking outside
const handleClickOutside = (event) => {
  const nav = event.target.closest('.navbar')
  if (!nav && isMobileMenuOpen.value) {
    closeMobileMenu()
  }
}

// Close mobile menu on resize if screen becomes larger
const handleResize = () => {
  if (window.innerWidth > 768) {
    closeMobileMenu()
  }
}

onMounted(() => {
  document.addEventListener('click', handleClickOutside)
  window.addEventListener('resize', handleResize)
})

onUnmounted(() => {
  document.removeEventListener('click', handleClickOutside)
  window.removeEventListener('resize', handleResize)
})
</script>

<style scoped>
.navbar {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background: rgba(255, 255, 255, 0.95);
  backdrop-filter: blur(10px);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  z-index: 1000;
  padding: 0;
}

.nav-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 80px;
}

.nav-logo {
  text-decoration: none;
  font-size: 1.5rem;
  font-weight: 700;
  color: #2c3e50;
  transition: color 0.3s ease;
}

.nav-logo:hover {
  color: #667eea;
}

.logo-text {
  background: linear-gradient(45deg, #667eea, #764ba2);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.nav-menu {
  display: flex;
  gap: 2rem;
  align-items: center;
}

.nav-link {
  text-decoration: none;
  color: #2c3e50;
  font-weight: 500;
  padding: 0.5rem 0;
  position: relative;
  transition: color 0.3s ease;
}

.nav-link::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 0;
  height: 2px;
  background: linear-gradient(45deg, #667eea, #764ba2);
  transition: width 0.3s ease;
}

.nav-link:hover::after,
.nav-link.active::after {
  width: 100%;
}

.nav-link:hover,
.nav-link.active {
  color: #667eea;
}

.mobile-menu-btn {
  display: none;
  flex-direction: column;
  cursor: pointer;
  padding: 0.5rem;
}

.mobile-menu-btn span {
  width: 25px;
  height: 3px;
  background: #2c3e50;
  margin: 3px 0;
  transition: 0.3s;
  border-radius: 2px;
}

.mobile-menu {
  display: none;
  background: white;
  padding: 1rem 0;
  border-top: 1px solid #e9ecef;
}

.mobile-nav-link {
  display: block;
  padding: 1rem 20px;
  text-decoration: none;
  color: #2c3e50;
  font-weight: 500;
  transition: background-color 0.3s ease;
  border-left: 3px solid transparent;
}

.mobile-nav-link:hover,
.mobile-nav-link.active {
  background: #f8f9fa;
  border-left-color: #667eea;
  color: #667eea;
}

/* Mobile responsive */
@media (max-width: 768px) {
  .nav-menu {
    display: none;
  }

  .mobile-menu-btn {
    display: flex;
  }

  .mobile-menu {
    display: block;
  }

  .nav-container {
    padding: 0 15px;
  }
}

/* Animation for mobile menu */
.slide-down-enter-active,
.slide-down-leave-active {
  transition: all 0.3s ease;
  max-height: 300px;
  overflow: hidden;
}

.slide-down-enter-from,
.slide-down-leave-to {
  max-height: 0;
  opacity: 0;
}

/* Desktop hover effects */
@media (min-width: 769px) {
  .nav-link {
    position: relative;
    overflow: hidden;
  }

  .nav-link::before {
    content: '';
    position: absolute;
    top: 0;
    left: -100%;
    width: 100%;
    height: 100%;
    background: linear-gradient(45deg, transparent, rgba(102, 126, 234, 0.1), transparent);
    transition: left 0.5s ease;
  }

  .nav-link:hover::before {
    left: 100%;
  }
}
</style>