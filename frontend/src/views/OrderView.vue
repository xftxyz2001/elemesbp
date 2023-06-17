<script setup lang="ts">
import FooterSection from '@/components/FooterSection.vue';
</script>

<template>
  <div class="wrapper">

    <!-- header部分 -->
    <header>
      <p>我的订单</p>
    </header>

    <!-- 订单列表部分 -->
    <h3>未支付订单信息：</h3>

    <h3>未评价订单信息：</h3>

    <h3>已完成订单信息：</h3>

    <!-- 底部菜单部分 -->
    <FooterSection />

  </div>
</template>

<style scoped>
/****************** 总容器 ******************/
.wrapper {
  width: 100%;
  height: 100%;
}

/****************** header部分 ******************/
.wrapper header {
  width: 100%;
  height: 12vw;
  background-color: #0097FF;
  color: #fff;
  font-size: 4.8vw;

  position: fixed;
  left: 0;
  top: 0;
  z-index: 1000;

  display: flex;
  justify-content: center;
  align-items: center;
}

/****************** 历史订单列表部分 ******************/
.wrapper h3 {
  margin-top: 12vw;
  box-sizing: border-box;
  padding: 4vw;
  font-size: 4vw;
  font-weight: 300;
  color: #999;
}

.wrapper .order {
  width: 100%;
}

.wrapper .order li {
  width: 100%;
}

.wrapper .order li .order-info {
  box-sizing: border-box;
  padding: 2vw 4vw;
  font-size: 4vw;
  color: #666;

  display: flex;
  justify-content: space-between;
  align-items: center;
}

.wrapper .order li .order-info .order-info-right {
  display: flex;
}

.wrapper .order li .order-info .order-info-right .order-info-right-icon {
  background-color: #f90;
  color: #fff;
  border-radius: 3px;
  margin-left: 2vw;
  user-select: none;
  cursor: pointer;
}

.wrapper .order li .order-info .order-info-right .order-info-right-icon2 {
  background-color: #ffaaff;
  color: #fff;
  border-radius: 3px;
  margin-left: 2vw;
  user-select: none;
  cursor: pointer;
}

.wrapper .order li .order-info .order-info-right .order-info-right-icon3 {
  background-color: #ddd;
  color: #fff;
  border-radius: 3px;
  margin-left: 2vw;
  user-select: none;
  cursor: pointer;
}

.wrapper .order li .order-detailet {
  width: 100%;
}

.wrapper .order li .order-detailet li {
  width: 100%;
  box-sizing: border-box;
  padding: 1vw 4vw;
  color: #666;
  font-size: 3vw;

  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
