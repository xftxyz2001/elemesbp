let api = [];
const apiDocListSize = 1
api.push({
    name: 'default',
    order: '1',
    list: []
})
api[0].list.push({
    alias: 'BusinessController',
    order: '1',
    link: '商家相关',
    desc: '商家相关',
    list: []
})
api[0].list[0].list.push({
    order: '1',
    deprecated: 'false',
    url: '/business/business/{businessid}',
    desc: '根据商家编号查询商家信息',
});
api[0].list[0].list.push({
    order: '2',
    deprecated: 'false',
    url: '/business/ordertype/{ordertypeid}',
    desc: '根据点餐分类查询商家信息',
});
api[0].list[0].list.push({
    order: '3',
    deprecated: 'false',
    url: '/business/list',
    desc: '返回所有商家信息（分页）',
});
api[0].list[0].list.push({
    order: '4',
    deprecated: 'false',
    url: '/business/businessname/{businessname}',
    desc: '根据商家名称查询商家信息',
});
api[0].list[0].list.push({
    order: '5',
    deprecated: 'false',
    url: '/business/businessaddress/{businessaddress}',
    desc: '根据商家地址查询商家信息',
});
api[0].list.push({
    alias: 'CartController',
    order: '2',
    link: '购物车相关',
    desc: '购物车相关',
    list: []
})
api[0].list[1].list.push({
    order: '1',
    deprecated: 'false',
    url: '/cart/count/{businessid}',
    desc: '统计当前用户在指定店家的购物车项数',
});
api[0].list[1].list.push({
    order: '2',
    deprecated: 'false',
    url: '/cart/business/{businessid}',
    desc: '当前用户在指定店家的购物车',
});
api[0].list[1].list.push({
    order: '3',
    deprecated: 'false',
    url: '/cart/business/{businessid}/with/food',
    desc: '当前用户在指定店家的购物车（包含食品信息）',
});
api[0].list[1].list.push({
    order: '4',
    deprecated: 'false',
    url: '/cart/info/{businessid}',
    desc: '当前用户在指定店家的购物车信息',
});
api[0].list[1].list.push({
    order: '5',
    deprecated: 'false',
    url: '/cart/update',
    desc: '更新购物车',
});
api[0].list.push({
    alias: 'DeliveryAddressController',
    order: '3',
    link: '配送地址相关',
    desc: '配送地址相关',
    list: []
})
api[0].list[2].list.push({
    order: '1',
    deprecated: 'false',
    url: '/daddress/list',
    desc: '列出用户的所有配送地址',
});
api[0].list[2].list.push({
    order: '2',
    deprecated: 'false',
    url: '/daddress/{daid}',
    desc: '根据配送地址编号查询配送地址',
});
api[0].list[2].list.push({
    order: '3',
    deprecated: 'false',
    url: '/daddress/save',
    desc: '添加配送地址',
});
api[0].list[2].list.push({
    order: '4',
    deprecated: 'false',
    url: '/daddress/{daid}',
    desc: '删除配送地址',
});
api[0].list.push({
    alias: 'FoodController',
    order: '4',
    link: '食品相关',
    desc: '食品相关',
    list: []
})
api[0].list[3].list.push({
    order: '1',
    deprecated: 'false',
    url: '/food/business/{businessid}',
    desc: '根据商家编号查询商家下的食品列表',
});
api[0].list[3].list.push({
    order: '2',
    deprecated: 'false',
    url: '/food/business/{businessid}/with/quantity',
    desc: '根据商家编号查询商家下的食品列表（包括购物车）',
});
api[0].list.push({
    alias: 'OrdersController',
    order: '5',
    link: '订单相关',
    desc: '订单相关',
    list: []
})
api[0].list[4].list.push({
    order: '1',
    deprecated: 'false',
    url: '/orders/user/{userid}',
    desc: '根据用户编号查询订单',
});
api[0].list[4].list.push({
    order: '2',
    deprecated: 'false',
    url: '/orders/list',
    desc: '获取当前用户的订单',
});
api[0].list[4].list.push({
    order: '3',
    deprecated: 'false',
    url: '/orders/{orderid}',
    desc: '根据订单编号查询订单',
});
api[0].list[4].list.push({
    order: '4',
    deprecated: 'false',
    url: '/orders/detailet/{orderid}',
    desc: '根据订单编号查询订单详细信息',
});
api[0].list[4].list.push({
    order: '5',
    deprecated: 'false',
    url: '/orders/new',
    desc: '创建订单',
});
api[0].list[4].list.push({
    order: '6',
    deprecated: 'false',
    url: '/orders/pay/{orderid}',
    desc: '',
});
api[0].list.push({
    alias: 'UserController',
    order: '6',
    link: '用户相关',
    desc: '用户相关',
    list: []
})
api[0].list[5].list.push({
    order: '1',
    deprecated: 'false',
    url: '/user/login',
    desc: '用户登录',
});
api[0].list[5].list.push({
    order: '2',
    deprecated: 'false',
    url: '/user/logout',
    desc: '用户登出',
});
api[0].list[5].list.push({
    order: '3',
    deprecated: 'false',
    url: '/user/check/{userid}',
    desc: '检查用户名是否存在',
});
api[0].list[5].list.push({
    order: '4',
    deprecated: 'false',
    url: '/user/register',
    desc: '用户注册',
});
api[0].list[5].list.push({
    order: '5',
    deprecated: 'false',
    url: '/user/delete',
    desc: '用户注销',
});
api[0].list[5].list.push({
    order: '6',
    deprecated: 'false',
    url: '/user/{userid}',
    desc: '用户查询（根据id）',
});
api[0].list[5].list.push({
    order: '7',
    deprecated: 'false',
    url: '/user/info',
    desc: '获取当前用户信息',
});
api[0].list.push({
    alias: 'dict',
    order: '7',
    link: 'dict_list',
    desc: '数据字典',
    list: []
})
api[0].list[6].list.push({
    order: '1',
    deprecated: 'false',
    url: '',
    desc: '状态码字典',
});
document.onkeydown = keyDownSearch;
function keyDownSearch(e) {
    const theEvent = e;
    const code = theEvent.keyCode || theEvent.which || theEvent.charCode;
    if (code === 13) {
        const search = document.getElementById('search');
        const searchValue = search.value.toLocaleLowerCase();

        let searchGroup = [];
        for (let i = 0; i < api.length; i++) {

            let apiGroup = api[i];

            let searchArr = [];
            for (let i = 0; i < apiGroup.list.length; i++) {
                let apiData = apiGroup.list[i];
                const desc = apiData.desc;
                if (desc.toLocaleLowerCase().indexOf(searchValue) > -1) {
                    searchArr.push({
                        order: apiData.order,
                        desc: apiData.desc,
                        link: apiData.link,
                        list: apiData.list
                    });
                } else {
                    let methodList = apiData.list || [];
                    let methodListTemp = [];
                    for (let j = 0; j < methodList.length; j++) {
                        const methodData = methodList[j];
                        const methodDesc = methodData.desc;
                        if (methodDesc.toLocaleLowerCase().indexOf(searchValue) > -1) {
                            methodListTemp.push(methodData);
                            break;
                        }
                    }
                    if (methodListTemp.length > 0) {
                        const data = {
                            order: apiData.order,
                            desc: apiData.desc,
                            link: apiData.link,
                            list: methodListTemp
                        };
                        searchArr.push(data);
                    }
                }
            }
            if (apiGroup.name.toLocaleLowerCase().indexOf(searchValue) > -1) {
                searchGroup.push({
                    name: apiGroup.name,
                    order: apiGroup.order,
                    list: searchArr
                });
                continue;
            }
            if (searchArr.length === 0) {
                continue;
            }
            searchGroup.push({
                name: apiGroup.name,
                order: apiGroup.order,
                list: searchArr
            });
        }
        let html;
        if (searchValue === '') {
            const liClass = "";
            const display = "display: none";
            html = buildAccordion(api,liClass,display);
            document.getElementById('accordion').innerHTML = html;
        } else {
            const liClass = "open";
            const display = "display: block";
            html = buildAccordion(searchGroup,liClass,display);
            document.getElementById('accordion').innerHTML = html;
        }
        const Accordion = function (el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;
            const links = this.el.find('.dd');
            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown);
        };
        Accordion.prototype.dropdown = function (e) {
            const $el = e.data.el;
            let $this = $(this), $next = $this.next();
            $next.slideToggle();
            $this.parent().toggleClass('open');
            if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp("20").parent().removeClass('open');
            }
        };
        new Accordion($('#accordion'), false);
    }
}

function buildAccordion(apiGroups, liClass, display) {
    let html = "";
    if (apiGroups.length > 0) {
        if (apiDocListSize === 1) {
            let apiData = apiGroups[0].list;
            let order = apiGroups[0].order;
            for (let j = 0; j < apiData.length; j++) {
                html += '<li class="'+liClass+'">';
                html += '<a class="dd" href="#_'+order+'_'+apiData[j].order+'_' + apiData[j].link + '">' + apiData[j].order + '.&nbsp;' + apiData[j].desc + '</a>';
                html += '<ul class="sectlevel2" style="'+display+'">';
                let doc = apiData[j].list;
                for (let m = 0; m < doc.length; m++) {
                    let spanString;
                    if (doc[m].deprecated === 'true') {
                        spanString='<span class="line-through">';
                    } else {
                        spanString='<span>';
                    }
                    html += '<li><a href="#_'+order+'_' + apiData[j].order + '_' + doc[m].order + '_' + doc[m].desc + '">' + apiData[j].order + '.' + doc[m].order + '.&nbsp;' + spanString + doc[m].desc + '<span></a> </li>';
                }
                html += '</ul>';
                html += '</li>';
            }
        } else {
            for (let i = 0; i < apiGroups.length; i++) {
                let apiGroup = apiGroups[i];
                html += '<li class="'+liClass+'">';
                html += '<a class="dd" href="#_'+apiGroup.order+'_' + apiGroup.name + '">' + apiGroup.order + '.&nbsp;' + apiGroup.name + '</a>';
                html += '<ul class="sectlevel1">';

                let apiData = apiGroup.list;
                for (let j = 0; j < apiData.length; j++) {
                    html += '<li class="'+liClass+'">';
                    html += '<a class="dd" href="#_'+apiGroup.order+'_'+ apiData[j].order + '_'+ apiData[j].link + '">' +apiGroup.order+'.'+ apiData[j].order + '.&nbsp;' + apiData[j].desc + '</a>';
                    html += '<ul class="sectlevel2" style="'+display+'">';
                    let doc = apiData[j].list;
                    for (let m = 0; m < doc.length; m++) {
                       let spanString;
                       if (doc[m].deprecated === 'true') {
                           spanString='<span class="line-through">';
                       } else {
                           spanString='<span>';
                       }
                       html += '<li><a href="#_'+apiGroup.order+'_' + apiData[j].order + '_' + doc[m].order + '_' + doc[m].desc + '">'+apiGroup.order+'.' + apiData[j].order + '.' + doc[m].order + '.&nbsp;' + spanString + doc[m].desc + '<span></a> </li>';
                   }
                    html += '</ul>';
                    html += '</li>';
                }

                html += '</ul>';
                html += '</li>';
            }
        }
    }
    return html;
}