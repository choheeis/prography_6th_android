package com.example.prographytest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.prographytest.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*




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

        // Bottom Navigation과 ViewPager간의 연결을 위한 리스너 설정
        BottomNavigationListener()
        ViewPagerListener()

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

    /** Bottom Navigation이 반응하는 리스너
     * --> Bottom Navigation Item 클릭시 ViewPager를 통해 해당 화면으로 슬라이드 시키기 위함 */
    fun BottomNavigationListener(){
        bottomNavigationBar.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener{
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when(item.itemId){
                        R.id.item_calls -> {
                            // 클릭한 Bottom Navigation item에 해당하는 화면으로 강제 슬라이드
                            myViewPager.currentItem = 0
                            return true
                        }
                        R.id.item_movieList -> {
                            myViewPager.currentItem = 1
                            return true
                        }
                        R.id.item_contacts -> {
                            myViewPager.currentItem = 2
                            return true
                        }
                        else -> return false
                    }
                }
            }
        )
    }

    /** ViewPager이 반응하는 리스너
     * --> ViewPager로 넘어간 화면에 해당하는 Bottom Navigation item 활성화 시키기 위함 */
    fun ViewPagerListener(){
        viewPager.addOnPageChangeListener(
            object : ViewPager.OnPageChangeListener{
                override fun onPageScrollStateChanged(state: Int) {

                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    // 슬라이드 된 화면에 해당하는 Bottom Navigation item을 활성화시킴
                    bottomNavigationBar.menu.getItem(position).isChecked = true
                }

            }
        )
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
