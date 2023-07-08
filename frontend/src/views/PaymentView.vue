<script setup lang="ts">
import axios from 'axios';
import {onBeforeMount, ref} from 'vue';
import type { Ref } from 'vue/dist/vue.js';
import {useRoute} from "vue-router";
import FooterSection from "@/components/FooterSection.vue";
import router from '@/router';

const isShowDetailet = ref(false);
const route =  useRoute();
interface BusinessItem {
  businessid: number; // 商家编号
  businessname: string; // 商家名称
  businessaddress: string; // 商家地址
  businessexplain: string; // 商家介绍
  businessimg: string; // 商家图片（base64）
  ordertypeid: number; // 点餐分类
  starprice: number; // 起送费
  deliveryprice: number; // 配送费
  remarks: string; // 备注
}
interface FoodItem {
  foodid: number; // 食品编号
  foodname: string; // 食品名称
  foodexplain: string; // 食品介绍
  foodimg: string; // 食品图片（base64）
  foodprice: number; // 食品价格
  businessid: number; // 商家编号
  remarks: string; // 备注

  quantity: number; // 食品数量
}
interface OrderItem{
  orderid:number;
  userid:string;
  businessid:number;
  orderdate:string;
  ordertotal:number;
  daid:number;
  orderState:number;
  foodList:FoodItem[];
  business:BusinessItem;

}

const orderid = route.params.id;
const orderList : Ref<OrderItem | null> = ref(null);
function detailetShow() {
  isShowDetailet.value = !isShowDetailet.value;
}
onBeforeMount(()=>{
  axios.get('/orders/detailet/' + orderid).then((res) => {
    let r = res.data;
    if(r.code == 0){
      orderList.value = r.data;
    }

  })
})
// 确认支付
function confirmPayment() {
  alert("支付成功");
  router.push("/myorder");
}

// interface ModalBox {
//   modal: HTMLElement;
//   triggerBtn: HTMLElement;
//   show: () => void;
//   close: () => void;
//   outsideClick: () => void;
//   init: () => void;
// }

// const modalBox: ModalBox = {
//   modal: document.getElementById("myModal")!,
//   triggerBtn: document.getElementById("triggerBtn")!,
//   show() {
//     this.modal.style.display = "block";
//   },
//   close() {
//     this.modal.style.display = "none";
//   },
//   outsideClick() {
//     const modal = this.modal;
//     window.onclick = function (event: MouseEvent) {
//       if (event.target === modal) {
//         modal.style.display = "none";
//       }
//     };
//   },
//   init() {
//     const that = this;
//     this.triggerBtn.onclick = function () {
//       that.show();
//     };
//     this.outsideClick();
//   },
// };

// modalBox.init();

function payment(){
  let modal = document.getElementById("myModal")!;
  modal.style.display = "block";
  window.onclick = function(event: MouseEvent) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  };
}
</script>

<template>
  <div class="wrapper">

    <!-- header部分 -->
    <header>
      <p>在线支付</p>
    </header>

    <!-- 订单信息部分 -->
    <h3>订单信息：</h3>
    <div class="order-info">
      <p>
        {{ orderList?.business.businessname }}
        <i v-show="isShowDetailet" class="fa fa-caret-up" @click="detailetShow"></i>
        <i v-show="!isShowDetailet" class="fa fa-caret-down" @click="detailetShow"></i>

      </p>
      <p>&#165;{{ orderList?.ordertotal }}</p>
    </div>

    <!-- 订单明细部分 -->
    <ul class="order-detailet" v-show="isShowDetailet">
      <li v-for="food in orderList?.foodList" :key="food.foodid">
        <p>{{ food.foodname }} x {{ food.quantity }}</p>
        <p>&#165;{{ food.foodprice * food.quantity }}</p>
      </li>
      <li>
        <p>配送费</p>
        <p>&#165;{{ orderList?.business.deliveryprice }}</p>
      </li>
    </ul>

    <!-- 支付方式部分 
		<ul class="payment-type">
			<li>
				<img src="../assets/zhifubao.png">
				<i class="fa fa-check-circle"></i>
			</li>
			<li>
				<img src="../assets/wechat.png">
			</li>
		</ul>
		<div class="payment-button">
			<button>确认支付</button>
		</div>-->

    <div class="payment-button">
      <button id="triggerBtn" @click="payment()">支付</button>
    </div>
    <!---新支付方式部分--->
    <!-- 模态框 -->
    <div id="myModal" class="modal">
      <div class="modal-content">
        <div class="modal-header">
          <div>支付方式</div>
          <!-- <span id="closeBtn" class="close">×</span> -->
        </div>
        <div class="modal-body">
          <div class="payway" style="border-bottom:1px solid #f5f5f5">
            <span>支付宝支付</span>
            <input type="radio" name="pay" value="" checked style="float:right" />
          </div>
          <div class="payway" style="margin-bottom:2vh;">
            <span>微信支付</span>
            <input type="radio" name="pay" value="" style="float:right" />
          </div>
        </div>
        <div class="bottom_pay_btn" id="payBtn" @click="confirmPayment()">确认支付</div>
      </div>
    </div>

    <!-- 底部菜单部分 -->
    <FooterSection/>
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

/****订单信息部分***/
.wrapper h3 {
  margin-top: 12vw;
  box-sizing: border-box;
  padding: 4vw 4vw 0;

  font-size: 4vw;
  font-weight: 300;
  color: #999;
}

.wrapper .order-info {
  box-sizing: border-box;
  padding: 4vw;
  font-size: 4vw;
  color: #666;

  display: flex;
  justify-content: space-between;
  align-items: center;
}

.wrapper .order-info p:last-child {
  color: orangered;
}

/****订单明细部分***/
.wrapper .order-detailet {
  width: 100%;
}

.wrapper .order-detailet li {
  width: 100%;
  box-sizing: border-box;
  padding: 1vw 4vw;

  display: flex;
  justify-content: space-between;
  align-items: center;
}

.wrapper .order-detailet li p {
  font-size: 3vw;
  color: #666;
}

/******支付方式部分*****/
/* .wrapper .payment-type {
		width: 100%;
	}
	
	.wrapper .payment-type li {
		width: 100%;
		box-sizing: border-box;
		padding: 4vw;
	
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	
	.wrapper .payment-type li img {
		width: 33vw;
		height: 8.9vw;
	}
	
	.wrapper .payment-type li .fa-check-circle {
		font-size: 5vw;
		color: #38CA73;
	} */

.wrapper .payment-button {
  width: 100%;
  box-sizing: border-box;
  padding: 4vw;
}

.wrapper .payment-button button {
  width: 100%;
  height: 10vw;
  border: none;
  outline: none;
  border-radius: 4px;
  background-color: #38CA73;
  color: #fff;
}

/******新做的支付方式*******/
.wrapper .bottom_btns {
  width: 100%;
  position: absolute;
  bottom: 3vh;
  text-align: center;
}

.wrapper .bottom_btns .common_btn_style {
  width: 46%;
  padding: 1vh 0;
  color: #fff;
  border-radius: 3px;
  float: left
}

.wrapper .bottom_btns .res_btn {
  background: #ebc071;
}

.wrapper .bottom_btns .buy_btn {
  background: #d44239;
  margin-left: 1%;
}

.wrapper body {
  overflow: hidden;
}

.wrapper .payway {
  padding: 2vh 0;
  font-size: 13px;
}

/* -----------------------------模态框样式-------------------------------- */
.wrapper .modal {
  display: none;
  /* 默认隐藏 */
  position: fixed;
  /* 根据浏览器定位 */
  z-index: 1;
  /* 放在底部 */
  left: 0;
  bottom: 10px;
  width: 100%;
  /* 全宽 */
  height: 100%;
  /* 全高 */
  overflow: hidden;
  /* 允许滚动 */
  background-color: rgba(0, 0, 0, 0.4);
  /* 背景色 */
}

/*模态框内容*/
.wrapper .modal .modal-content {
  display: flex;
  /*采用flexbox布局*/
  flex-direction: column;
  /*垂直排列*/
  position: absolute;
  bottom: 0;
  background-color: #fefefe;
  /* margin: 127% 0;  */
  padding: 20px;
  width: 100%;
  animation: topDown 0.4s;
  /*自定义动画，从模态框内容上到下出现*/
}

/* .wrapper @keyframes topDown {
		from {
			bottom: -100px;
			opacity: 0
		}
	
		to {
			bottom: 0px;
			opacity: 1
		}
	} */

.wrapper .bottom_pay_btn {
  position: absolute;
  bottom: 0.5vh;
  width: 89%;
  /* margin-left:1%; */
  height: 33px;
  line-height: 33px;
  color: #fff;
  text-align: center;
  background: #57dcd8;
  border-radius: 4px;

}

/*模态框头部*/
.wrapper .modal .modal-content .modal-header {
  display: flex;
  /*采用flexbox布局*/
  flex-direction: row;
  /*水平布局*/
  align-items: center;
  /*内容垂直居中*/
  justify-content: space-between;
}

/*关闭X 样式*/
/* .wrapper .close {
		color: #aaa;
		float: right;
		font-size: 28px;
		font-weight: bold;
	}
	
	.wrapper .close:hover {
		color: black;
		text-decoration: none;
		cursor: pointer;
	} */

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

.wrapper .footer li p:last-child {
  font-size: 2.8vw;
}

.wrapper .footer li i {
  font-size: 5vw;
}
</style>
