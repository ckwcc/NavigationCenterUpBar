package com.ckw.zfsoft.votedemo;

import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ckw.zfsoft.votedemo.add.NewAddFragment;
import com.ckw.zfsoft.votedemo.draft.DraftFragment;
import com.ckw.zfsoft.votedemo.participant.ParticipantFragment;
import com.ckw.zfsoft.votedemo.sponsor.SponsorFragment;
import com.ckw.zfsoft.votedemo.whole.WholeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG_WHOLE_FRAGMENT = "WholeFragment";
    private static final String TAG_ADD_FRAGMENT = "NewAddFragment";
    private static final String TAG_PARTICIPANT_FRAGMENT = "ParticipantFragment";
    private static final String TAG_DRAFT_FRAGMENT = "DraftFragment";
    private static final String TAG_SPONSOR_FRAGMENT = "SponsorFragment";

    private NewAddFragment mNewAddFragment;//新增的
    private DraftFragment mDraftFragment;//草稿
    private ParticipantFragment mParticipantFragment;//参与的
    private SponsorFragment mSponsorFragment;//发起的
    private WholeFragment mWholeFragment;//全部

    private LinearLayout mAddContainer;
    private LinearLayout mDraftContainer;
    private LinearLayout mPartContainer;
    private LinearLayout mSponsorContainer;
    private LinearLayout mWholeContainer;
    private TextView mAddText;
    private TextView mDraftText;
    private TextView mPartText;
    private TextView mSponsorText;
    private TextView mWholeText;
    private ImageView mAddImg;
    private ImageView mDraftImg;
    private ImageView mPartImg;
    private ImageView mSponsorImg;
    private ImageView mWholeImg;

    private int mCurrentItem = 0;
    private int mLastItem = 0;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragmentManager();
        initSavedInstanceState(savedInstanceState);
        showFragment(mCurrentItem);
        initListener();

    }

    private void initSavedInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            mCurrentItem = savedInstanceState.getInt("currentItem");
            mWholeFragment = (WholeFragment) mFragmentManager.findFragmentByTag(TAG_WHOLE_FRAGMENT);
            mSponsorFragment = (SponsorFragment) mFragmentManager.findFragmentByTag(TAG_SPONSOR_FRAGMENT);
            mNewAddFragment = (NewAddFragment) mFragmentManager.findFragmentByTag(TAG_ADD_FRAGMENT);
            mParticipantFragment = (ParticipantFragment) mFragmentManager.findFragmentByTag(TAG_PARTICIPANT_FRAGMENT);
            mDraftFragment = (DraftFragment) mFragmentManager.findFragmentByTag(TAG_DRAFT_FRAGMENT);
        }else {
            mWholeFragment = WholeFragment.newInstance();
            mSponsorFragment = SponsorFragment.newInstance();
            mNewAddFragment = NewAddFragment.newInstance();
            mParticipantFragment = ParticipantFragment.newInstance();
            mDraftFragment = DraftFragment.newInstance();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("currentItem", mCurrentItem);
    }

    private void showFragment(int index){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        setTextViewDefaultColor();
        switch (index){
            case 0:
                mWholeText.setTextColor(getResources().getColor(R.color.colorAccent));
                mWholeImg.setImageResource(R.mipmap.bule_two_circle);
                if(mWholeFragment != null && !mWholeFragment.isAdded()){
                    ActivityUtils.addFragmentToActivityWithTag(mFragmentManager,mWholeFragment,R.id.rl_vote_container,TAG_WHOLE_FRAGMENT);
                }
                hideAllFragment(transaction);
                transaction.show(mWholeFragment);
                break;
            case 1:
                mSponsorText.setTextColor(getResources().getColor(R.color.colorAccent));
                mSponsorImg.setImageResource(R.mipmap.bule_two_circle);
                if(mSponsorFragment != null && !mSponsorFragment.isAdded()){
                    ActivityUtils.addFragmentToActivityWithTag(mFragmentManager,mSponsorFragment,R.id.rl_vote_container,TAG_SPONSOR_FRAGMENT);
                }
                hideAllFragment(transaction);
                transaction.show(mSponsorFragment);
                break;
            case 2:
                mAddText.setTextColor(getResources().getColor(R.color.colorAccent));
                mAddImg.setImageResource(R.mipmap.bule_two_circle);
                if(mNewAddFragment != null && !mNewAddFragment.isAdded()){
                    ActivityUtils.addFragmentToActivityWithTag(mFragmentManager,mNewAddFragment,R.id.rl_vote_container,TAG_ADD_FRAGMENT);
                }
                hideAllFragment(transaction);
                transaction.show(mNewAddFragment);
                break;
            case 3:
                mPartText.setTextColor(getResources().getColor(R.color.colorAccent));
                mPartImg.setImageResource(R.mipmap.bule_two_circle);
                if(mParticipantFragment != null && !mParticipantFragment.isAdded()){
                    ActivityUtils.addFragmentToActivityWithTag(mFragmentManager,mParticipantFragment,R.id.rl_vote_container,TAG_PARTICIPANT_FRAGMENT);
                }
                hideAllFragment(transaction);
                transaction.show(mParticipantFragment);
                break;
            case 4:
                mDraftText.setTextColor(getResources().getColor(R.color.colorAccent));
                mDraftImg.setImageResource(R.mipmap.bule_two_circle);
                if(mDraftFragment != null && !mDraftFragment.isAdded()){
                    ActivityUtils.addFragmentToActivityWithTag(mFragmentManager,mDraftFragment,R.id.rl_vote_container,TAG_DRAFT_FRAGMENT);
                }
                hideAllFragment(transaction);
                transaction.show(mDraftFragment);
                break;
        }

        transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction transaction){
        transaction
                .hide(mWholeFragment)
                .hide(mSponsorFragment)
                .hide(mNewAddFragment)
                .hide(mParticipantFragment)
                .hide(mDraftFragment);
    }

    private void initFragmentManager() {
        mFragmentManager = getSupportFragmentManager();
    }

    private void initListener() {
        mAddContainer.setOnClickListener(this);
        mDraftContainer.setOnClickListener(this);
        mPartContainer.setOnClickListener(this);
        mSponsorContainer.setOnClickListener(this);
        mWholeContainer.setOnClickListener(this);
    }

    private void initView() {
        mAddContainer = (LinearLayout) findViewById(R.id.ll_vote_add);
        mDraftContainer = (LinearLayout)findViewById(R.id.ll_vote_draft);
        mPartContainer = (LinearLayout)findViewById(R.id.ll_vote_participant);
        mSponsorContainer = (LinearLayout)findViewById(R.id.ll_vote_sponsor);
        mWholeContainer = (LinearLayout)findViewById(R.id.ll_vote_whole);
        mAddText = (TextView) findViewById(R.id.tv_vote_add);
        mDraftText =(TextView) findViewById(R.id.tv_vote_draft);
        mPartText = (TextView)findViewById(R.id.tv_vote_participant);
        mSponsorText = (TextView)findViewById(R.id.tv_vote_sponsor);
        mWholeText = (TextView)findViewById(R.id.tv_vote_whole);
        mAddImg  = (ImageView)findViewById(R.id.iv_vote_add);
        mDraftImg = (ImageView)findViewById(R.id.iv_vote_draft);
        mPartImg = (ImageView)findViewById(R.id.iv_vote_participant);
        mSponsorImg = (ImageView)findViewById(R.id.iv_vote_sponsor);
        mWholeImg = (ImageView)findViewById(R.id.iv_vote_whole);
    }

    /**
     * 设置被选中item的文本颜色
     */
    private void setTextViewDefaultColor(){
        //所有文本先设置回默认颜色
        mAddText.setTextColor(getResources().getColor(R.color.colorBlack));
        mDraftText.setTextColor(getResources().getColor(R.color.colorBlack));
        mPartText.setTextColor(getResources().getColor(R.color.colorBlack));
        mSponsorText.setTextColor(getResources().getColor(R.color.colorBlack));
        mWholeText.setTextColor(getResources().getColor(R.color.colorBlack));
    }

    /**
     * 将上一个被选中的item的图片设置回原来的模样
     * @param lastItem
     */
    private void setLastImageViewNormal(int lastItem){
        switch (lastItem){
            case 0:
                mWholeImg.setImageResource(R.mipmap.ic_launcher);
                break;
            case 1:
                mSponsorImg.setImageResource(R.mipmap.ic_launcher);
                break;
            case 2:
                mAddImg.setImageResource(R.mipmap.ic_launcher);
                break;
            case 3:
                mPartImg.setImageResource(R.mipmap.ic_launcher);
                break;
            case 4:
                mDraftImg.setImageResource(R.mipmap.ic_launcher);
                break;

        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        mLastItem = mCurrentItem;
        setLastImageViewNormal(mLastItem);
        switch (id){
            case R.id.ll_vote_whole:
                    mCurrentItem = 0;
                    showFragment(mCurrentItem);
                break;
            case R.id.ll_vote_sponsor:
                    mCurrentItem = 1;
                    showFragment(mCurrentItem);
                break;
            case R.id.ll_vote_add:
                    mCurrentItem = 2;
                    showFragment(mCurrentItem);
                break;
            case R.id.ll_vote_participant:
                    mCurrentItem = 3;
                    showFragment(mCurrentItem);
                break;
            case R.id.ll_vote_draft:
                    mCurrentItem = 4;
                    showFragment(mCurrentItem);
                break;
        }
    }
}
