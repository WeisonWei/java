package com.weison;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author weixiaoxing
 * @date 2020/9/2
 */
public class JsonTest {

    @Test
    public void covertToJson() {
        String str = "{\n" +
                "  \"gmt_create\": \"2020-09-02 12:05:46\",\n" +
                "  \"charset\": \"utf-8\",\n" +
                "  \"seller_email\": \"meishubao1v1@qq.com\",\n" +
                "  \"subject\": \"美术宝写字体验课\",\n" +
                "  \"sign\": \"Dpx/qkjUApkGd84yQhejv9XVj9XarQPw8YLsCGFtVjf51xQ61fuL361+iO5rnMLFUC8NDphBQfhgUASkqcsp9huBh/TeE1Zu4oM2QkpoirKsmDG9ZX3y/AD3qI29goJ7ulFD5b85ZS73cVXlcohJnbo12pPHr23SrTNf/up3S5qnXe2NL1yqBXQFeu7xq4E5Lh+ZTUsPsQVXNAOMx7lxzrLzPX2iIo1GiYO4V4GM3KvJYhJHFDgFJ0HzdTfOBIZCHidkiF7hbqAOfkAqM0tPqOm2fcoVtlQf9m5y2ZLLER8vv+QAG5l939RfSRoTT8WsgLRFwNYXu66a5TruQy9p/Q==\",\n" +
                "  \"buyer_id\": \"2088102702539597\",\n" +
                "  \"invoice_amount\": \"0.01\",\n" +
                "  \"notify_id\": \"2020090200222120547039591419623081\",\n" +
                "  \"fund_bill_list\": \"[{\\\"amount\\\":\\\"0.01\\\",\\\"fundChannel\\\":\\\"PCREDIT\\\"}]\",\n" +
                "  \"notify_type\": \"trade_status_sync\",\n" +
                "  \"trade_status\": \"TRADE_SUCCESS\",\n" +
                "  \"receipt_amount\": \"0.01\",\n" +
                "  \"buyer_pay_amount\": \"0.01\",\n" +
                "  \"app_id\": \"2021001191600034\",\n" +
                "  \"sign_type\": \"RSA2\",\n" +
                "  \"seller_id\": \"2088921870903937\",\n" +
                "  \"gmt_payment\": \"2020-09-02 12:05:46\",\n" +
                "  \"notify_time\": \"2020-09-02 12:05:47\",\n" +
                "  \"passback_params\": \"{\\\"couponUserId\\\":\\\"0\\\",\\\"subject\\\":\\\"write\\\",\\\"type\\\":\\\"ALONE\\\",\\\"grouponId\\\":\\\"0\\\"}\",\n" +
                "  \"version\": \"1.0\",\n" +
                "  \"out_trade_no\": \"xiong2020090212052835966\",\n" +
                "  \"total_amount\": \"0.01\",\n" +
                "  \"trade_no\": \"2020090222001439591452617639\",\n" +
                "  \"auth_app_id\": \"2021001191600034\",\n" +
                "  \"buyer_logon_id\": \"707***@qq.com\",\n" +
                "  \"point_amount\": \"0.00\"\n" +
                "}";

        JSONObject jsonObject = JSONUtil.parseObj(str);
        String subject = Objects.nonNull(jsonObject.get("subject")) ?
                jsonObject.get("subject").toString() : "ai";

        System.out.println("==subject==" + subject);
    }
}
