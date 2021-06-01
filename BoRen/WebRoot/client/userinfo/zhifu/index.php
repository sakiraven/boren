<?php
/* *
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 */

?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	<title>Hack易支付免签约即时到账交易接口</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

</head>
<body text=#000000 bgColor=#ffffff leftMargin=0 topMargin=4>
	 <form name=alipayment action=epayapi.php method=post target="_blank">
        <div id="body" style="clear:left">
            <dl class="content">
                <dd>
                    <input  size="30" name="WIDout_trade_no" value="<?php echo date("YmdHis").mt_rand(100,999); ?>"/>
                </dd>
                <dd>
                    <input hidden size="30" name="WIDsubject" value="钱包充值"/>
                </dd>
                <dd>
                    <input  size="30" name="WIDtotal_fee" value="10"/>
                </dd>
                <dd>
                    <label><input type="radio" name="type" value="alipay" checked="">支付宝</label>&nbsp;<label><input type="radio" name="type" value="qqpay">QQ钱包</label>&nbsp;<label><input type="radio" name="type" value="wxpay">微信支付</label>
                </dd>
                <dt></dt>
                <dd>
                        <span class="new-btn-login-sp">
                            <button class="new-btn-login" type="submit" style="text-align:center;">确 认</button>
                        </span>
                </dd>
            </dl>
        </div>
    </form>
</body>
</html>
<script src=""></script>
