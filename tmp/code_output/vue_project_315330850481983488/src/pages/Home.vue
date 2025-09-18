<template>
  <div class="home">
    <h1>博客文章</h1>
    <ul>
      <li v-for="article in articles" :key="article.id">
        <router-link :to="`/article/${article.id}`">{{ article.title }}</router-link>
      </li>
    </ul>
  </div>
</template>

<script setup>
const articles = [
  { id: 1, title: 'Vue3 入门指南', content: '这是关于 Vue3 的入门教程。' },
  { id: 2, title: '组合式 API 实践', content: '学习如何使用 Vue3 的组合式 API。' },
  { id: 3, title: 'Vite 快速开发', content: '使用 Vite 提升开发效率。' }
]
</script>

<style>
.home {
  padding: 20px;
}

ul {
  list-style: none;
  padding: 0;
}

li {
  margin: 10px 0;
}

a {
  text-decoration: none;
  color: #333;
}

a:hover {
  text-decoration: underline;
}
</style>