package com.acecounter.android.acetmtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.acecounter.android.acetm.AceTM;
import com.acecounter.android.acetm.parameter.Parameter;
import com.acecounter.android.acetm.parameter.Product;
import com.acecounter.android.acetmtest.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AceTM.onCreate(this);
        setLayout();
    }

    private void setLayout() {
        findViewById(R.id.buttonPv).setOnClickListener(this);
        findViewById(R.id.buttonPu).setOnClickListener(this);
        findViewById(R.id.buttonPagErr).setOnClickListener(this);
        findViewById(R.id.buttonHref).setOnClickListener(this);
        findViewById(R.id.buttonTel).setOnClickListener(this);
        findViewById(R.id.buttonSNS).setOnClickListener(this);
        findViewById(R.id.buttonClick).setOnClickListener(this);
        findViewById(R.id.buttonBc).setOnClickListener(this);
        findViewById(R.id.buttonBv).setOnClickListener(this);
        findViewById(R.id.buttonJSErr).setOnClickListener(this);
        findViewById(R.id.buttonNow).setOnClickListener(this);
        findViewById(R.id.buttonWish).setOnClickListener(this);
        findViewById(R.id.buttonCart).setOnClickListener(this);
        findViewById(R.id.buttonBuy).setOnClickListener(this);
        findViewById(R.id.buttonBuyDirect).setOnClickListener(this);
        findViewById(R.id.buttonBuyCredit).setOnClickListener(this);
        findViewById(R.id.buttonBuyEtc).setOnClickListener(this);
        findViewById(R.id.buttonPay).setOnClickListener(this);
        findViewById(R.id.buttonReview).setOnClickListener(this);
        findViewById(R.id.buttonLogin).setOnClickListener(this);
        findViewById(R.id.buttonJoin).setOnClickListener(this);
        findViewById(R.id.buttonDetailView).setOnClickListener(this);
        findViewById(R.id.buttonDeactivate).setOnClickListener(this);
        findViewById(R.id.buttonInnerSearch).setOnClickListener(this);
        findViewById(R.id.buttonHybridWeb).setOnClickListener(this);
        findViewById(R.id.buttonGoIntro).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonPv:
                AceTM.pv(this);
                break;
            case R.id.buttonPu:
                AceTM.login(this, "mox70501", 25, Parameter.Gender.WOMAN);
                //AceTM.pu(this);
                break;
            case R.id.buttonPagErr:
                AceTM.pageErr(this);
                break;
            case R.id.buttonHref:
                AceTM.href(this, "test.php");
                break;
            case R.id.buttonTel:
                AceTM.tel(this, "010-5048-2839");
                break;
            case R.id.buttonSNS:
                AceTM.sns(this, Integer.toString((int) (Math.random() * 100000)), "KakaoTalk");
                break;
            case R.id.buttonClick:
                AceTM.customerClick(this, "무언가 클릭");
                break;
            case R.id.buttonBc:
                AceTM.bannerClick(this, 1, 2);
                break;
            case R.id.buttonBv:
                AceTM.bannerView(this, 1, 3);
                break;
            case R.id.buttonJSErr:
                AceTM.codeErr(this, 100, "무언가 오류");
                break;
            case R.id.buttonNow:
                Product product1 = new Product("샤프랑 130ml", "10000", 2000., 4);
                AceTM.buyNow(this, product1);
                break;
            case R.id.buttonWish:
                Product product2 = new Product("샤프랑 130ml", "10000", 2000., 4);
                product2.addOption(new Product.Option("20000", "하얀색", 2));
                product2.addOption(new Product.Option("30000", "검은색", 4));
                AceTM.wishList(this, product2);
                break;
            case R.id.buttonCart:
                Product product3 = new Product("샤프랑 130ml", "10000", 2000., 4);
                product3.addOption(new Product.Option("20000", "하얀색", 2));
                product3.addOption(new Product.Option("30000", "검은색", 4));
                AceTM.addCart(this, product3);
                break;
            case R.id.buttonBuy:
                break;
            case R.id.buttonBuyDirect:
                Product product5 = new Product("샤프랑 130ml", "10000", 2000., 4);
                product5.addOption(new Product.Option("20000", "하얀색", 2));
                product5.addOption(new Product.Option("30000", "검은색", 4));
                AceTM.buyList(this, "무통장", Integer.toString((int) (Math.random() * 100000)), 50000.0, product5);
                break;
            case R.id.buttonBuyCredit:
                Product product4 = new Product("샤프랑 130ml", "10000", 2000., 4);
                product4.addOption(new Product.Option("20000", "하얀색", 2));
                product4.addOption(new Product.Option("30000", "검은색", 4));
                AceTM.buyList(this, "신용카드", Integer.toString((int) (Math.random() * 100000)), 50000.0, product4);
                break;
            case R.id.buttonBuyEtc:
                Product product6 = new Product("샤프랑 130ml", "10000", 2000., 4);
                product6.addOption(new Product.Option("20000", "하얀색", 2));
                product6.addOption(new Product.Option("30000", "검은색", 4));
                AceTM.buyList(this, "기타", Integer.toString((int) (Math.random() * 100000)), 50000.0, product6);
                break;
            case R.id.buttonPay:
                Product product7 = new Product("샤프랑 130ml", "10000", 2000., 4);
                product7.addOption(new Product.Option("20000", "하얀색", 2));
                product7.addOption(new Product.Option("30000", "검은색", 4));
                AceTM.pay(this, "카카오톡 페이", product7);
                break;
            case R.id.buttonReview:
                AceTM.review(this, Integer.toString((int) (Math.random() * 100000)), "이 상품 별로에요", 5);
                break;
            case R.id.buttonLogin:
                AceTM.login(this, "mox7050", 25, Parameter.Gender.MAN);
                break;
            case R.id.buttonJoin:
                AceTM.join(this, "dotoro22", 1000);
                break;
            case R.id.buttonDeactivate:
                AceTM.deactivate(this, "mox70522");
                break;
            case R.id.buttonDetailView:
                AceTM.detailView(this, "1242332", "샤프랑 201ml", 10000, "가정용품", "http://test.com/test.jpg");
                break;
            case R.id.buttonInnerSearch:
                AceTM.innerSearch(this, "사프란");
                break;
            case R.id.buttonHybridWeb:
                startActivity(new Intent(this, HybridWebActivity.class));
                break;
            case R.id.buttonGoIntro:
                startActivity(new Intent(this, IntroActivity.class));
                break;

        }
    }


}
