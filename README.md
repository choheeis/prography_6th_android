# 💁‍♀️ prography_6th_android

### 👉 프로그라피 6기 사전과제

1. ViewPager를 이용하여 Fragment를 전환하고 이를 Bottom Navigation View와 연결하기

2. Bottom Navigation Bar의 가운데 탭에 recyclerView를 만든 후, 서버 통신하기

3. recyclerView의 각 item을 클릭하여 새로운 activity를 띄우고 putExtra를 이용하여 데이터 넘기기

 <br>

### 👉 사전과제 결과물 제출

- __1. Bottom Navigation View 구현__

    Bottom Navigation Bar는 총 3개의 menu로 구성하였습니다. (CALLS, MOVIES, CONTACTS 순)

    Bottom Navigation Bar를 구현하기 위해 사용한 라이브러리는 다음과 같습니다.

    ~~~kotlin
    implementation 'com.google.android.material:material:1.0.0'
    ~~~


    Bottom Navigation Bar의 각 메뉴를 클릭했을 때와 클릭하지 않았을 때 색깔 차이를 두기 위해 selector를 적용하였습니다.

    <br>

    - CALLS menu를 클릭했을 경우 보이는 화면

        ![01](https://user-images.githubusercontent.com/31889335/75954224-884dfe80-5ef6-11ea-8f71-298c432f2acf.PNG)

        <br>

    - MOVEIS menu를 클릭했을 경우 보이는 화면

        ![02](https://user-images.githubusercontent.com/31889335/75954225-884dfe80-5ef6-11ea-95b7-61a8463122c0.PNG)

        <br>

    - CONTACTS menu를 클릭했을 경우 보이는 화면

        ![04](https://user-images.githubusercontent.com/31889335/75954221-871cd180-5ef6-11ea-9d8c-b39e9e39da2f.PNG)

        <br>

- __2. recyclerView 구현 및 서버 통신__

    recyclerView를 구현하기 위해 사용한 라이브러리는 

    ~~~kotlin
    implementation 'androidx.recyclerview:recyclerview:1.0.0'
    ~~~ 

    이고, 레트로핏을 사용하여 서버 통신을 하기 위해 사용한 라이브러리는 다음과 같습니다.

    ~~~kotlin
    implementation 'com.squareup.retrofit2:retrofit:2.7.2'
    implementation 'com.squareup.retrofit2:converter-gson:2.6.2'
    implementation 'com.google.code.gson:gson:2.8.6'
    ~~~

    서버에 요청을 하기 위해 사용되는 함수를 interface 안에 정의하였고, 레트로핏의 실제 구현체는 object 안에 정의하여 어느 클래스에서나 접근하여 사용하기 쉽도록 했습니다.

    ~~~kotlin
    interface ApiService {
        @GET("/films")
        fun requestFilmsList() : Call<List<DataDefine>>
    }
    ~~~

    ~~~kotlin
    object ServerImpl {

    private const val BASE_URL = "https://ghibliapi.herokuapp.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: ApiService = retrofit.create(ApiService::class.java)
    }
    ~~~

    <br>

    - MOVIES menu 화면을 클릭하면 보이는 recyclerView

        ![02](https://user-images.githubusercontent.com/31889335/75954225-884dfe80-5ef6-11ea-95b7-61a8463122c0.PNG)

        <br>

- __3. recyclerView의 각 item을 클릭했을 경우 영화 정보를 볼 수 있는 상세 페이지 구현하기__

    recyclerView 리스트를 띄우기 위해 얻은 데이터를 PutExtra를 통해 새로운 Activity로 넘겨주었습니다.

    새로운 Activity에서는 PutExtra로 넘겨진 데이터를 받아 적합한 View에 적용시켰습니다.

    <br>

    - recyclerView의 각 item을 클릭했을 경우 보이는 화면 (Pom Poko라는 영화를 클리한 경우)

        ![03](https://user-images.githubusercontent.com/31889335/75954226-88e69500-5ef6-11ea-998c-d54772da4292.PNG)

        <br>

- 추가 - 프로젝트의 구조를 직관적으로 보기 위해 폴더를 data, server, ui로 나누었습니다.

    ![05](https://user-images.githubusercontent.com/31889335/75955524-5722fd80-5ef9-11ea-8b4b-1ddc27fc316f.PNG)

    <br>

### 👉 최종 결과

![prograph_6th_kimchohee](https://user-images.githubusercontent.com/31889335/75953866-a5360200-5ef5-11ea-8cf8-9109335503db.gif)

<br>

