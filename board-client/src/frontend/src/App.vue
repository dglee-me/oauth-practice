<script setup lang="ts">
import {onMounted, ref} from 'vue'
import type {User} from 'oidc-client-ts'
import {userManager} from '@/auth'

const user = ref<User | null>(null)
const posts = ref('')

onMounted(async () => {
  if (window.location.pathname === '/callback') {
    await userManager.signinRedirectCallback()
    window.history.replaceState({}, '', '/')
  }

  user.value = await userManager.getUser()
})

async function login() {
  await userManager.signinRedirect()
}

async function logout() {
  await userManager.signoutRedirect()
}

async function loadPosts() {
  if (!user.value?.access_token) {
    throw new Error('Access Token이 없습니다.')
  }

  const response = await fetch('/api/posts', {
    headers: {
      Authorization: `Bearer ${user.value.access_token}`,
    },
  })

  posts.value = await response.text()
}
</script>

<template>
  <main>
    <button v-if="!user" @click="login">
      로그인
    </button>

    <template v-else>
      <p>{{ user.profile.sub }}님</p>

      <button @click="loadPosts">
        게시글 조회
      </button>

      <button @click="logout">
        로그아웃
      </button>

      <p>{{ posts }}</p>
    </template>
  </main>
</template>
