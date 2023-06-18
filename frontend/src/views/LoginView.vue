<script setup lang="ts">
import FooterSection from '@/components/FooterSection.vue';
import { ref } from 'vue';
import axios from 'axios';
import router from '@/router';

const userid = ref('');
const password = ref('');

// 手机号码验证
function phoneVerify(phone: string) {
  return /^((13\d)|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[0,1,3,5,7,8])|(18[0-9])|(19[8,9]))\d{8}/.test(phone);
}

// 登录
function login() {
  console.log(userid.value, password.value);
  // 数据验证
  if (userid.value.length < 1) {
    alert('手机号码不能为空');
    return;
  }
  // 测试太费劲，先注释掉
  // if (!phoneVerify(userid.value)) {
  //   alert('手机号码格式不正确');
  //   return;
  // }
  if (password.value.length < 1) {
    alert('密码不能为空');
    return;
  }

  // 发送请求
  const data = {
    userid: userid.value,
    password: password.value,
  };

  axios.post('/user/login', data).then(res => {
    let r = res.data;
    if (r.code == 0) {
      alert('登录成功');
      // 跳转到首页
      router.push('/');
    } else {
      alert(r.msg);
    }
  })

}
</script>

<template>
  <div class="wrapper">

    <!-- header部分 -->
    <header>
      <p>用户登录</p>
    </header>

    <!-- 表单部分 -->
    <ul class="form-box">
      <li>
        <div class="title">
          手机号码：
        </div>
        <div class="content">
          <input type="text" v-model="userid" placeholder="手机号码">
        </div>
      </li>
      <li>
        <div class="title">
          密码：
        </div>
        <div class="content">
          <input type="password" v-model="password" placeholder="密码">
        </div>
      </li>
    </ul>

    <div class="button-login">
      <button @click="login">登录</button>
    </div>
    <div class="button-register">

      <router-link to="/register">
        <button>去注册</button>
      </router-link>
    </div>

    <!-- 底部菜单部分 -->
    <FooterSection />
  </div>
</template>

<style scoped>
/****总容器部分***/
.wrapper {
  width: 100%;
  height: 100%;
}

/****header部分***/
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

/******表单部分*****/
.wrapper .form-box {
  width: 100%;
  margin-top: 12vw;
}

.wrapper .form-box li {
  box-sizing: border-box;
  padding: 4vw 3vw 0 3vw;

  display: flex;
  align-items: center;
}

.wrapper .form-box li .title {
  flex: 0 0 18vw;
  font-size: 3vw;
  font-weight: 700;
  color: #666;
}

.wrapper .form-box li .content {
  flex: 1;
}

.wrapper .form-box li .content input {
  border: none;
  outline: none;
  width: 100%;
  height: 4vw;
  font-size: 3vw;
}

.wrapper .button-login {
  width: 100%;
  box-sizing: border-box;
  padding: 4vw 3vw 0 3vw;
}

.wrapper .button-login button {
  width: 100%;
  height: 10vw;
  font-size: 3.8vw;
  font-weight: 700;
  color: #fff;
  background-color: #38CA73;
  border-radius: 4px;

  border: none;
  outline: none;
}

.wrapper .button-register {
  width: 100%;
  box-sizing: border-box;
  padding: 4vw 3vw 0 3vw;
}

.wrapper .button-register button {
  width: 100%;
  height: 10vw;
  font-size: 3.8vw;
  font-weight: 700;
  color: #666;
  background-color: #EEE;
  border-radius: 4px;

  border: none;
  outline: none;
  border: solid 1px #DDD;
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
