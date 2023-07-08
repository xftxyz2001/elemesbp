<script setup lang="ts">
import FooterSection from '@/components/FooterSection.vue';
import axios from 'axios';
import { ref } from 'vue';
import { useRoute } from 'vue-router';
import router from "@/router";

const route = useRoute();

const daid = route.params.id;

const deliveryAddress = ref({
  daid: 0,
  contactname: '',
  contactsex: 1,
  contacttel: '',
  address: '',
  userid: '',
});

axios.get('/daddress/' + daid).then((res) => {
  let r = res.data;
  if (r.code == 0) {
    if(r.data)
    deliveryAddress.value = r.data;
  }
});
//daddress/save
function saveUserAddress() {
  console.log(deliveryAddress.value);
  let param = {
    contactname: deliveryAddress.value.contactname,
    contactsex: deliveryAddress.value.contactsex,
    contacttel: deliveryAddress.value.contacttel,
    address: deliveryAddress.value.address
  };
  axios.post('/daddress/save', param).then(res => {
    let r = res.data;
    if (r.code == 0) {
      router.push({name:'userAddress'});
      console.log('更新成功');
    } else {
      alert(r.msg);
    }
  });
}
</script>

<template>
  <div class="wrapper">

    <!-- header部分 -->
    <header>
      <p>编辑送货地址</p>
    </header>

    <!-- 表单部分 -->
    <ul class="form-box">
      <li>
        <div class="title">
          联系人：
        </div>
        <div class="content">
          <input type="text" v-model="deliveryAddress.contactname" placeholder="联系人姓名">
        </div>
      </li>
      <li>
        <div class="title">
          性别：
        </div>
        <div class="content" style="font-size: 3vw;">
          <input type="radio" name="gender" v-model="deliveryAddress.contactsex" value="1" style="width:6vw;height:3.2vw;">男
          <input type="radio" name="gender" v-model="deliveryAddress.contactsex" value="0" style="width:6vw;height:3.2vw;">女
        </div>
      </li>
      <li>
        <div class="title">
          电话：
        </div>
        <div class="content">
          <input type="tel" v-model="deliveryAddress.contacttel" placeholder="电话">
        </div>
      </li>
      <li>
        <div class="title">
          收货地址：
        </div>
        <div class="content">
          <input type="text" v-model="deliveryAddress.address" placeholder="收货地址">
        </div>
      </li>
    </ul>
    <div class="button-add">
      <button @click="saveUserAddress">保存</button>
    </div>

    <!-- 底部菜单部分 -->
    <FooterSection />

  </div>
</template>

<style scoped>
/*************** 总容器 ***************/
.wrapper {
  width: 100%;
  height: 100%;
}

/*************** header ***************/
.wrapper header {
  width: 100%;
  height: 12vw;
  background-color: #0097FF;
  display: flex;
  justify-content: space-around;
  align-items: center;
  color: #fff;
  font-size: 4.8vw;
  position: fixed;
  left: 0;
  top: 0;
  /*保证在最上层*/
  z-index: 1000;
}

/*************** （表单信息） ***************/
.wrapper .form-box {
  width: 100%;
  margin-top: 12vw;
}

.wrapper .form-box li {
  box-sizing: border-box;
  padding: 4vw 3vw 0vw 3vw;
  display: flex;
}

.wrapper .form-box li .title {
  flex: 0 0 18vw;
  font-size: 3vw;
  font-weight: 700;

  color: #666;
}

.wrapper .form-box li .content {
  flex: 1;

  display: flex;
  align-items: center;
}

.wrapper .form-box li .content input {
  border: none;
  outline: none;
  width: 100%;
  height: 4vw;
  font-size: 3vw;
}

.wrapper .button-add {
  box-sizing: border-box;
  padding: 4vw 3vw 0vw 3vw;
}

.wrapper .button-add button {
  width: 100%;
  height: 10vw;
  font-size: 3.8vw;
  font-weight: 700;

  border: none;
  outline: none;
  border-radius: 4px;
  color: #fff;
  background-color: #38CA73;
}
</style>
