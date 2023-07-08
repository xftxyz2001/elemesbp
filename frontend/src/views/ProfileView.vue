<script setup lang="ts">
import FooterSection from '@/components/FooterSection.vue';
import router from "@/router";
import axios from 'axios';
import { onBeforeMount, ref } from "vue";
interface User {
  userid: string
  username: string
  usersex: number
  userimg: string
}
const user = ref<User | null>(null);

onBeforeMount(() => {
  axios.get('/user/info').then((res) => {
    let r = res.data;
    if (r.code == 0) {
      user.value = r.data;
    }
  })
});

function logout() {
  axios.post('/user/logout').then((res) => {
    let r = res.data;
    if (r.code == 0) {
      ElMessage({
        message: "退出成功",
        type: "success"
      })
      router.push({ name: "login" });
    }
  })
}

</script>

<template>
  <!--总容器-->
  <div class="wrapper">

    <!--header部分-->
    <header>
      <div class="userInfo">
        <img :src="user?.userimg">
        <div class="location-text">
          <div class="name">
            {{ user?.username }}
          </div>
          <div class="phone">
            {{ user?.userid }}
          </div>
        </div>
      </div>
      <div class="modify">
        <i class="fa fa-sign-out" @click="logout"></i>
      </div>
    </header>

    <!--用户信息部分-->
    <ul class="userinfo">
      <li>
        <img src="../assets/收藏.png">
        <p>收藏</p>
      </li>
      <li>
        <img src="../assets/足迹.png">
        <p>足迹</p>
      </li>
      <li>
        <img src="../assets/红包卡券.png">
        <p>红包卡券</p>
      </li>
      <li>
        <img src="../assets/余额.png">
        <p>余额</p>
      </li>
    </ul>

    <!--我的订单部分-->
    <ul class="listinfo">
      <p>
        我的订单
        <p2>
          全部订单 <i class="fa fa-angle-right"></i>
        </p2>
      </p>
    </ul>
    <ul class="listinfo">
      <pic>
        <li>
          <img src="../assets/待付款.png">
          <p>待付款</p>
        </li>
        <li>
          <img src="../assets/足迹.png">
          <p>待收货</p>
        </li>
        <li>
          <img src="../assets/待使用.png">
          <p>待使用</p>
        </li>
        <li>
          <img src="../assets/红包卡券.png">
          <p>待评价</p>
        </li>
        <li>
          <img src="../assets/余额.png">
          <p>退款售后</p>
        </li>
      </pic>
    </ul>

    <!--会员广告部分-->
    <div class="banner"></div>

    <!--吃货豆部分-->
    <div class="banner2"></div>

    <div style="height: 14vw;"></div>

    <!-- 底部菜单部分 -->
    <FooterSection />

  </div>
</template>

<style scoped>
/****总容器部分***/
.wrapper {
  width: 100%;
  height: 100%;
  background-color: #eee;
}

/*.wrapper :last-child::after{*/
/*  content: "";*/
/*  display: block;*/
/*  padding-bottom: 14vw;*/
/*}*/

/****header部分***/
.wrapper header {
  width: 100%;
  height: 18vw;
  background-color: #FFFFF3;

  display: flex;
  align-items: center;
}

.wrapper header .userInfo {

  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper header .userInfo img {
  width: 12vw;
  height: 12vw;
  margin: 0 1vw 0 3vw;
}

/* .wrapper header img2 {
		width: 8vw;
		height: 8vw;
		margin: 0 1vw 0 3vw;
	}

	.wrapper header img3 {
		width: 8vw;
		height: 8vw;
		margin: 0 1vw 0 3vw;
	} */

/*定位小图标 */
/* 	.wrapper header .userInfo .icon-location-box {
		width: 3.5vw;
		height: 3.5vw;
		margin: 0 1vw 0 3vw;
	} */

.wrapper header .userInfo .location-text {
  font-size: 4.5vw;
  font-weight: 600;
  color: #555;
  margin-left: 1.5vw;
}

.wrapper header .userInfo .location-text .name {
  font-size: 4vw;
}

.wrapper header .userInfo .location-text .phone {
  font-size: 3.6vw;
  color: #777;
}

.wrapper header .modify {
  margin-left: 38vw;
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper header .modify .fa-sign-out {
  margin-right: 2vw;
  font-size: 6vw;
}

.wrapper header .modify .fa-refresh {
  font-size: 5vw;
}

/****search部分***/
.wrapper .search {
  width: 100%;
  height: 13vw;
}

.wrapper .search .search-fixed-top {
  width: 100%;
  height: 13vw;
  background-color: #0097FF;
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .search .search-fixed-top .search-box {
  width: 90%;
  height: 9vw;
  background-color: #fff;
  border-radius: 2px;

  display: flex;
  justify-content: center;
  align-items: center;

  font-size: 3.5vw;
  color: #AEAEAE;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  /*此样式是让文本选中状态无效 */
  user-select: none;
}

.wrapper .search .search-fixed-top .search-box .fa-search {
  margin-right: 1vw;
}

/****用户信息部分***/
.wrapper .userinfo {
  width: 98%;
  height: 23vw;

  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-content: center;

  box-sizing: border-box;
  border-radius: 5px;
  padding: 2vw 4vw;
  margin-top: 1vw;
  margin-left: 1%;
  background-color: #fff;
}

.wrapper .userinfo li {
  width: 18vw;
  height: 20vw;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  user-select: none;
  cursor: pointer;
}

.wrapper .userinfo li img {
  width: 12vw;
  height: 10vw;
}

.wrapper .userinfo li p {
  font-size: 3.2vw;
  font-weight: 500;
  color: #666;
}

/****订单信息部分***/
.wrapper .listinfo {
  width: 98%;

  box-sizing: border-box;
  border-radius: 5px;
  background-color: #fff;
  margin-left: 1%;
  /* margin-top: 0.5vw; */
  border-bottom: solid 1px #ddd;
}

.wrapper .listinfo p {
  width: 88%;
  margin: 0 auto;
  height: vw;
  background-color: #ffffff;
  margin-top: 1.3vw;
  border-radius: 5px;
  color: #333;

  display: flex;
  justify-content: space-between;
  align-items: center;
}

.wrapper .listinfo p p2 {
  width: 25%;
  box-sizing: border-box;
  padding: 1vw 3.5vw;
  color: #666;
  font-size: 3vw;

  display: flex;
  justify-content: space-between;
  margin-right: -3vw;
}

.wrapper .listinfo p p2 i {
  font-size: 4vw;
}

.wrapper .listinfo pic {
  width: 100%;
  height: 23vw;

  display: flex;
  flex-wrap: wrap;
  /* flex-direction: column; */
  justify-content: space-between;
  align-content: center;

  box-sizing: border-box;
  padding: 2vw 2vw;

}

.wrapper .listinfo pic li {
  width: 18vw;
  height: 20vw;

  display: flex;
  flex-direction: column;
  justify-content: center;
  /* align-items: center; */

  user-select: none;
  cursor: pointer;
}

.wrapper .listinfo pic li img {
  width: 12vw;
  height: 10vw;
}

.wrapper .listinfo pic li p {
  font-size: 3.2vw;
  font-weight: 500;
  color: #666;
}

/****白银会员部分***/
.wrapper .banner {
  width: 98%;
  margin: 0 auto;
  height: 35vw;

  background-image: url(../assets/会员注册.png);
  background-repeat: no-repeat;
  background-size: cover;

  border-radius: 10px;
  box-sizing: border-box;
  padding: 4vw 6vw;
}

/****吃货豆部分***/
.wrapper .banner2 {
  width: 100%;
  margin: 0 auto;
  height: 55vw;

  background-image: url(../assets/tmp.png);
  background-repeat: no-repeat;
  background-size: cover;

  box-sizing: border-box;
  padding: 4vw 6vw;
}

/****超级会员部分***/
.wrapper .supermember {
  width: 95%;
  margin: 0 auto;
  height: 11.5vw;
  background-color: #FEEDC1;
  margin-top: 1.3vw;
  border-radius: 2px;
  color: #644F1B;

  display: flex;
  justify-content: space-between;
  align-items: center;
}

.wrapper .supermember .left {
  display: flex;
  align-items: center;
  margin-left: 4vw;
  user-select: none;
}

.wrapper .supermember .left img {
  width: 6vw;
  height: 6vw;
  margin-right: 2vw;
}

.wrapper .supermember .left h3 {
  font-size: 4vw;
  margin-right: 2vw;
}

.wrapper .supermember .left p {
  font-size: 3vw;
}

.wrapper .supermember .right {
  font-size: 3vw;
  margin-right: 4vw;
  cursor: pointer;
}

/****推荐商家部分***/
.wrapper .recommend {
  width: 100%;
  height: 14vw;
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .recommend .recommend-line {
  width: 6vw;
  height: 0.2vw;
  background-color: #888;
}

.wrapper .recommend p {
  font-size: 4vw;
  margin: 0 4vw;
}

/****推荐方式部分***/
.wrapper .recommendtype {
  width: 100%;
  height: 5vw;
  margin-bottom: 5vw;

  display: flex;
  justify-content: space-around;
  align-items: center;
}

.wrapper .recommendtype li {
  font-size: 3.5vw;
  color: #555;
}

/****推荐商家列表部分***/
.wrapper .business {
  width: 100%;
  padding-bottom: 14vw;
}

.wrapper .business li {
  width: 100%;
  box-sizing: border-box;
  padding: 2.5vw;
  user-select: none;
  border-bottom: solid 1px #DDD;
  display: flex;

}

.wrapper .business li img {
  width: 18vw;
  height: 18vw;
}

.wrapper .business li .business-info {
  width: 100%;
  box-sizing: border-box;
  padding-left: 3vw;
}

.wrapper .business li .business-info .business-info-h {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2vw;
}

.wrapper .business li .business-info .business-info-h h3 {
  font-size: 4vw;
  color: #333;
}

.wrapper .business li .business-info .business-info-h .business-info-like {
  width: 1.6vw;
  height: 3.4vw;
  background-color: #666;
  color: #fff;
  font-size: 4vw;
  margin-right: 4vw;

  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .business li .business-info .business-info-star {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2vw;
  font-size: 3.1vw;
}

.wrapper .business li .business-info .business-info-star .business-info-star-left {
  display: flex;
  align-items: center;
}

.wrapper .business li .business-info .business-info-star .business-info-star-left .fa-star {
  color: #FEC80E;
  margin-right: 0.5vw;
}

.wrapper .business li .business-info .business-info-star .business-info-star-left p {
  color: #666;
  margin-left: 1vw;
}

.wrapper .business li .business-info .business-info-star .business-info-star-right {
  background-color: #0097FF;
  color: #fff;
  font-size: 2.4vw;
  font-weight: 600;
  border-radius: 2px;
  padding: 0 0.6vw;
}

.wrapper .business li .business-info .business-info-delivery {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2vw;

  color: #666;
  font-size: 3.1vw;
}

.wrapper .business li .business-info .business-info-explain {
  display: flex;
  align-items: center;
  margin-bottom: 3vw;

}

.wrapper .business li .business-info .business-info-explain div {
  border: solid 1px #DDD;
  font-size: 2.8vw;
  color: #666;
  border-radius: 3px;
  padding: 0 0.1vw;
}

.wrapper .business li .business-info .business-info-promotion {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1.8vw;
}

.wrapper .business li .business-info .business-info-promotion .business-info-promotion-left {
  display: flex;
  align-items: center;

}

.wrapper .business li .business-info .business-info-promotion .business-info-promotion-left .business-info-promotion-left-icon {
  width: 4vw;
  height: 4vw;
  background-color: #70BC46;
  border-radius: 3px;
  font-size: 3vw;
  font-weight: 500;
  color: #fff;

  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .business li .business-info .business-info-promotion .business-info-promotion-left p {
  color: #666;
  font-size: 3vw;
  font-weight: 500;
  margin-left: 2vw;
}

.wrapper .business li .business-info .business-info-promotion .business-info-promotion-right {
  display: flex;
  align-items: center;
  font-size: 2.5vw;
  color: #999;
}

.wrapper .business li .business-info .business-info-promotion .business-info-promotion-right p {
  margin-right: 2vw;
}

/******底部菜单部分*****/
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
