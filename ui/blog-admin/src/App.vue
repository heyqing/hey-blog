<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
import { generaMenu } from '@/assets/js/menu'
import baseUrl from '@/util/baseUrl'
export default {
  created() {
    if (this.$store.state.userInfo != null) {
      generaMenu()
    }
    this.axios.post(`${baseUrl}/report`)
  }
}
</script>
