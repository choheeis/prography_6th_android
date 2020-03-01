package com.example.prographytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

// 화면 갯수 전역 변수로 설정
private const val NUM_PAGES = 3

class MainActivity : AppCompatActivity() {

    private lateinit var myViewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // activity_main.xml 에 배치한 viewPager를 변수화
        myViewPager = findViewById(R.id.viewPager)

        // ViewPagerAdapter를 myViewPager의 어댑터로 세팅
        val pagerAdapter: PagerAdapter = ViewPagerAdapter(supportFragmentManager)
        myViewPager.adapter = pagerAdapter
    }

    /** 뒤로가기 버튼 클릭시 화면 슬라이드 유무 설정 */
    override fun onBackPressed() {
        if(myViewPager.currentItem == 0){
            // 맨 첫 화면일 경우 activity finish
            super.onBackPressed()
        }else{
            // 아닐 경우 이전 화면으로 슬라이드 됨
            myViewPager.currentItem = myViewPager.currentItem - 1
        }

    }

    /** ViewPager가 사용하는 Adpater 클래스 */
    inner class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            // 슬라이드에 따른 화면 이동 관계 설정
            return when (position){
                0 -> return Fragment1()
                1 -> return Fragment2()
                2 -> return Fragment3()
                else -> return Fragment1()
            }
        }

        override fun getCount(): Int = NUM_PAGES

    }
}
