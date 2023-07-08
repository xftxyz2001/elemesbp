<script setup lang="ts">
import FooterSection from '@/components/FooterSection.vue';
import router from '@/router';
import { onMounted, onBeforeUnmount } from 'vue';

onMounted(() => {
  // 将搜索块固定到视口顶部
  document.onscroll = () => {
    //获取滚动条位置
    let s1 = document.documentElement.scrollTop;
    let s2 = document.body.scrollTop;
    let scroll = s1 == 0 ? s2 : s1;
    //获取视口宽度
    let width = document.documentElement.clientWidth;
    //获取顶部固定块
    let search = document.getElementById('fixedBox') as HTMLElement;

    //判断滚动条超过视口宽度的12%时，搜索块变成固定定位
    if (scroll > width * 0.12) {
      search.style.position = 'fixed';
      search.style.left = '0';
      search.style.top = '0';
    } else {
      search.style.position = 'static';
    }
  }
});

onBeforeUnmount(() => {
  // 组件卸载后去掉document滚动条事件
  document.onscroll = null;
});

// 根据商家类别跳转到商家列表页
function toBusinessList(type: number) {
  // 路由跳转
  router.push({
    name: 'businessList',
    params: {
      type: type
    }
  });
}

function nonsupport() {
  ElMessage({
    message: "暂不支持该功能",
    type: 'warning'
  });
}
</script>

<template>
  <div class="wrapper">
    <!--header部分-->
    <!-- <Search> </Search> -->

    <header>
      <div class="icon-location-box">
        <div class="icon-location"></div>
      </div>
      <div class="location-text">西安市西北大学长安校区<i class="fa fa-caret-down"></i></div>
    </header>

    <!--search部分-->
    <div class="search">
      <div class="search-fixed-top" id="fixedBox" ref="fixedBox">
        <div class="search-box" @click="nonsupport()">
          <i class="fa fa-search"></i>搜索饿了么商家、商品名称
        </div>
      </div>
    </div>

    <!--点餐分类部分-->
    <ul class="foodtype">
      <li @click="toBusinessList(1)">
        <img src="../assets/1.png">
        <p>美食</p>
      </li>
      <li @click="toBusinessList(2)">
        <img src="../assets/2.png">
        <p>早餐</p>
      </li>
      <li @click="toBusinessList(3)">
        <img src="../assets/3.png">
        <p>跑腿代购</p>
      </li>
      <li @click="toBusinessList(4)">
        <img src="../assets/4.png">
        <p>汉堡披萨</p>
      </li>
      <li @click="toBusinessList(5)">
        <img src="../assets/5.png">
        <p>甜品饮品</p>
      </li>
      <li @click="toBusinessList(6)">
        <img src="../assets/6.png">
        <p>速食简餐</p>
      </li>
      <li @click="toBusinessList(7)">
        <img src="../assets/7.png">
        <p>地方小吃</p>
      </li>
      <li @click="toBusinessList(8)">
        <img src="../assets/8.png">
        <p>米粉面馆</p>
      </li>
      <li @click="toBusinessList(9)">
        <img src="../assets/9.png">
        <p>包子粥铺</p>
      </li>
      <li @click="toBusinessList(10)">
        <img src="../assets/10.png">
        <p>炸鸡炸串</p>
      </li>
    </ul>
    <!--横幅广告部分-->
    <div class="banner">
      <h3>品质套餐</h3>
      <p>搭配齐全吃得好</p>
      <a>立即抢购 &gt;</a>
    </div>
    <!--超级会员部分-->
    <div class="supermember">
      <div class="left">
        <img src="../assets/king.png">
        <h3>超级会员</h3>
        <p>&#8226; 每月享超值权益</p>
      </div>
      <div class="right">
        立即开通 &gt;
      </div>
    </div>
    <!--推荐商家部分-->
    <div class="recommend">
      <div class="recommend-line"></div>
      <p>推荐商家</p>
      <div class="recommend-line"></div>
    </div>
    <!--推荐方式部分-->
    <ul class="recommendtype">
      <li>综合排序<i class="fa fa-caret-down"></i></li>
      <li>距离最近</li>
      <li>销量最高</li>
      <li>筛选<i class="fa fa-filter"></i></li>
    </ul>
    <!--推荐商家列表部分-->
    <ul class="business">
      <li>
        <img src="../assets/shop1.jpg">
        <div class="business-info">
          <div class="business-info-h">
            <h3>三可手工虾仁水饺（龙居店）</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>4.9 月售345单</p>
            </div>
            <div class="business-info-star-right">
              蜂鸟专送
            </div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>3.22km | 30分钟</p>
          </div>
          <div class="business-info-explain">
            <div>各种水饺</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>2个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon" style="background-color: #F1884F;">特</div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>
      <li>
        <img src="../assets/shop2.jpg">
        <div class="business-info">
          <div class="business-info-h">
            <h3>华桥披萨</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>4.9 月售345单</p>
            </div>
            <div class="business-info-star-right">
              蜂鸟专送
            </div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>3.22km | 30分钟</p>
          </div>
          <div class="business-info-explain">
            <div>披萨汉堡</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>2个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon" style="background-color: #F1884F;">特</div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>
      <li>
        <img src="../assets/shop3.jpg">
        <div class="business-info">
          <div class="business-info-h">
            <h3>海底捞外送（津南店）</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>4.9 月售345单</p>
            </div>
            <div class="business-info-star-right">
              蜂鸟专送
            </div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>3.22km | 30分钟</p>
          </div>
          <div class="business-info-explain">
            <div>火锅外送</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>2个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon" style="background-color: #F1884F;">特</div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>
      <li>
        <img src="../assets/shop4.jpg">
        <div class="business-info">
          <div class="business-info-h">
            <h3>麻辣龙虾坊（双港店）</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>4.9 月售345单</p>
            </div>
            <div class="business-info-star-right">
              蜂鸟专送
            </div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>3.22km | 30分钟</p>
          </div>
          <div class="business-info-explain">
            <div>麻辣龙虾</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>2个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon" style="background-color: #F1884F;">特</div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>
      <li>
        <img src="../assets/shop5.jpg">
        <div class="business-info">
          <div class="business-info-h">
            <h3>可可炸鸡汉堡</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>4.9 月售345单</p>
            </div>
            <div class="business-info-star-right">
              蜂鸟专送
            </div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>3.22km | 30分钟</p>
          </div>
          <div class="business-info-explain">
            <div>炸鸡汉堡</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>2个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon" style="background-color: #F1884F;">特</div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>
      <li>
        <img src="../assets/shop6.jpg">
        <div class="business-info">
          <div class="business-info-h">
            <h3>小周家凉皮（天津大学店）</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>4.9 月售345单</p>
            </div>
            <div class="business-info-star-right">
              蜂鸟专送
            </div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>3.22km | 30分钟</p>
          </div>
          <div class="business-info-explain">
            <div>凉皮凉粉</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>2个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon" style="background-color: #F1884F;">特</div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>
    </ul>
    <!--底部菜单部分-->
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

  display: flex;
  align-items: center;
}

/*定位小图标 */
.wrapper header .icon-location-box {
  width: 3.5vw;
  height: 3.5vw;
  margin: 0 1vw 0 3vw;
}

.wrapper header .location-text {
  font-size: 4.5vw;
  font-weight: 700;
  color: #fff;
}

.wrapper header .location-text .fa-caret-down {
  margin-left: 1vw;
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

/****点餐分类部分***/
.wrapper .foodtype {
  width: 100%;
  height: 48vw;

  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  align-content: center;
}

.wrapper .foodtype li {
  width: 18vw;
  height: 20vw;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  user-select: none;
  cursor: pointer;
}

.wrapper .foodtype li img {
  width: 12vw;
  height: 12vw;
}

.wrapper .foodtype li p {
  font-size: 3.2vw;
  font-weight: 500;
  color: #666;
}

/****横幅广告部分***/
.wrapper .banner {
  width: 95%;
  margin: 0 auto;
  height: 29vw;

  background-image: url(../assets/advertisement.png);
  background-repeat: no-repeat;
  background-size: cover;

  box-sizing: border-box;
  padding: 2vw 6vw;
}

.wrapper .banner h3 {
  font-size: 4.2vw;
  margin-bottom: 1.2vw;
}

.wrapper .banner p {
  font-size: 3.4vw;
  color: #666;
  margin-bottom: 2.4vw;
}

.wrapper .banner a {
  font-size: 3vw;
  color: #C79060;
  font-weight: 700;
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

/**评论**/
.wrapper .comment .content {
  width: 94%;
  margin-top: 2vw;
}

.wrapper .comment .content textarea {
  border: none;
  resize: none;
  outline-color: skyblue;
  background-color: #EEE;
}
</style>
