<script setup lang="ts">
import FooterSection from '@/components/FooterSection.vue';
import router from '@/router';
import axios from 'axios';
import { ref } from 'vue';

const registerForm = ref({
  userId: '',
  password: '',
  userName: '',
  userSex: 1
});

const confirmPassword = ref('');

// 手机号码验证
function phoneVerify(phone: string) {
  return /^((13\d)|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[0,1,3,5,7,8])|(18[0-9])|(19[8,9]))\d{8}/.test(phone);
}

// 用户名验证（检查是否存在）
function checkUserId() {
  console.log(registerForm.value.userId);
  if (registerForm.value.userId.length < 1) {
    ElMessage({
    message: '手机号码不能为空',
    type: 'warning'
  });
    return;
  }
  // 测试太费劲，先注释掉
  // if (!phoneVerify(userid.value)) {
  //   ElMessage({
    message: '手机号码格式不正确',
    type: 'warning'
  });
  //   return;
  // }
  // 发送请求
  axios.post(`/user/${registerForm.value.userId}`).then(res => {
    let r = res.data;
    if (r.code == 0) {
      ElMessage({
    message: '手机号码已存在',
    type: 'warning'
  });
      // 跳转到登录页
      router.push('/login');
    } else {
      ElMessage({
    message: r.msg,
    type: 'warning'
  });
    }
  })
}

// 密码验证（检查是否符合要求）
function checkPassword() { }

// 确认密码验证（检查两次输入是否一致）
function checkConfirmPassword() { 
  if (registerForm.value.password != confirmPassword.value) {
    ElMessage({
    message: '两次输入的密码不一致',
    type: 'warning'
  });
    return;
  }
}

// 注册
function register() {
  console.log(registerForm.value);
  // 数据验证
  if (registerForm.value.userId.length < 1) {
    ElMessage({
    message: '手机号码不能为空',
    type: 'warning'
  });
    return;
  }
  // 测试太费劲，先注释掉
  // if (!phoneVerify(userid.value)) {
  //   ElMessage({
    message: '手机号码格式不正确',
    type: 'warning'
  });
  //   return;
  // }
  if (registerForm.value.password.length < 1) {
    ElMessage({
    message: '密码不能为空',
    type: 'warning'
  });
    return;
  }
  

  // 发送请求
  const data = {
    userid: registerForm.value.userId,
    password: registerForm.value.password,
    username: registerForm.value.userName,
    usersex: registerForm.value.userSex
  };

  axios.post('/user/register', data).then(res => {
    let r = res.data;
    if (r.code == 0) {
      ElMessage({
    message: '注册成功',
    type: 'warning'
  });
      // 跳转到登录页
      router.push('/login');
    } else {
      ElMessage({
    message: r.msg,
    type: 'warning'
  });
    }
  })

}
</script>

<template>
  <div class="wrapper">

    <!-- header部分 -->
    <header>
      <p>用户注册</p>
    </header>

    <!-- 表单部分 -->
    <ul class="form-box">
      <li>
        <div class="title">
          手机号码：
        </div>
        <div class="content">
          <input type="text" v-model="registerForm.userId" @blur="checkUserId" placeholder="手机号码">
        </div>
      </li>
      <li>
        <div class="title">
          密码：
        </div>
        <div class="content">
          <input type="password" v-model="registerForm.password" @blur="checkPassword" placeholder="密码">
        </div>
      </li>
      <li>
        <div class="title">
          确认密码：
        </div>
        <div class="content">
          <input type="password" v-model="confirmPassword" @blur="checkConfirmPassword" placeholder="确认密码">
        </div>
      </li>
      <li>
        <div class="title">
          用户名称：
        </div>
        <div class="content">
          <input type="text" v-model="registerForm.userName" placeholder="用户名称">
        </div>
      </li>
      <li>
        <div class="title">
          性别：
        </div>
        <div class="content">
          <input type="radio" style="width: 6vw; height: 3.2vw;" v-model="registerForm.userSex" value="1">男
          <input type="radio" style="width: 6vw; height: 3.2vw;" v-model="registerForm.userSex" value="0">女
        </div>
      </li>
    </ul>

    <div class="button-login">
      <button @click="register">注册</button>
    </div>

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

/****************** 表单部分 ******************/
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
  font-size: 3vw;
}

/*
.wrapper .form-box li .content input {
  width: 6vw;
  height: 3.2vw;
}
*/

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
</style>
