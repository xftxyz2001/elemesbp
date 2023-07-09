<script setup lang="ts">
</script>

<template>
  <ul class="footer">
    <router-link to="/">
      <li>
        <i class="fa fa-home"></i>
        <p>首页</p>
      </li>
    </router-link>
    <router-link to="/discover">
      <li>
        <i class="fa fa-compass"></i>
        <p>发现</p>
      </li>
    </router-link>
    <router-link to="/myorder">
      <li>
        <i class="fa fa-file-text-o"></i>
        <p>订单</p>
      </li>
    </router-link>
    <router-link to="/profile">
      <li>
        <i class="fa fa-user-o"></i>
        <p>我的</p>
      </li>
    </router-link>
  </ul>
</template>

<style scoped>
.wrapper .footer {
  width: 100%;
  height: 14vw;
  border-top: solid 1px #DDD;
  background-color: #fff;

  position: fixed;
  left: 0;
  bottom: 0;

  display: flex;
  justify-content: space-around;
  align-items: center;
}

.wrapper .footer .router-link-active li{
  color: black;
}

.wrapper .footer li {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  color: #999;
  user-select: none;
  cursor: pointer;
}

.wrapper .footer li p {
  font-size: 2.8vw;
}

.wrapper .footer li i {
  font-size: 5vw;
}
</style>
