package com.practicum.tambovgurman.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.practicum.tambovgurman.R;
import com.practicum.tambovgurman.adapter.CategoryAdapter;
import com.practicum.tambovgurman.adapter.CourseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;

    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullcoursesList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.fullRestaurants);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCourseByCategory(RESET_CATEGORY);
            }
        });


        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Рестораны"));
        categoryList.add(new Category(2, "Кафе"));
        categoryList.add(new Category(3, "Пиццерии"));
        categoryList.add(new Category(4, "Бары"));
        categoryList.add(new Category(5, "Суши-бары"));

        setCategoryRecycler(categoryList);


        courseList.add(new Course(1, "beerlogovobolsche", "Ресторан BeerLogovo", "Октябрьская ул., 16", "4,9 ⭐", "1000 ₽", "#424345", "Ресторан с собственной пивоварней в центре Тамбова.\nСмешанная кухня (Европейская, Грузинская, Японская, Итальянская).\nСобственная доставка", "https://yandex.ru/maps/org/beerlogovo/9031573865/reviews/?ll=41.447026%2C52.725144&z=15", "https://yandex.ru/maps/org/beerlogovo/9031573865/?ll=41.447026%2C52.725144&z=15",  1));
        courseList.add(new Course(2, "dacha", "Ресторан Дача", "Коммунальная ул., 15", "5,0 ⭐", "800 ₽", "#ae8871", "Уютное место для всей семьи\nУвлекательный интерьер и атмосфера\nЗамечательный дружный персонал\n и просто очень вкусная еда", "https://yandex.ru/maps/org/dacha/95144070067/reviews/?ll=41.449897%2C52.723056&z=15","https://yandex.ru/maps/org/dacha/95144070067/?ll=41.449897%2C52.723056&z=15", 1));
        courseList.add(new Course(3, "starik", "Ресторан Старик Хинкалыч", "Коммунальная ул., 9", "4,8 ⭐", "500 ₽", "#ca9a5a", "Старик Хинкалыч отличается доступными ценами,\nминимальным временем ожидания блюд,\nколоритными интерьером и максимальным качеством!\nБудем рады видеть вас у нас в гостях!", "https://yandex.ru/maps/org/starik_khinkalych/117943161213/reviews/?ll=41.453082%2C52.723423&z=15", "https://yandex.ru/maps/org/starik_khinkalych/117943161213/?ll=41.453082%2C52.723423&z=15", 1));
        courseList.add(new Course(4, "proplov", "Ресторан ProПлов", "ул.Коммунальная, 18", "4,6 ⭐", "1000 ₽", "#654e43", "Ресторан с настоящей узбекской кухней\nСледуем традиции вкладывать душу в еду", "https://yandex.ru/maps/org/proplov/101726968912/reviews/?ll=41.448982%2C52.722063&z=15", "https://yandex.ru/maps/org/proplov/101726968912/?ll=41.448982%2C52.722063&z=15", 1));
        courseList.add(new Course(5, "grenok", "Ресторан Гренок", "ул.Карла Маркса, 146", "5,0 ⭐", "1500 ₽", "#1f1007", "Размеренная и доброжелательная атмосфера\nОформление зала, выполненное в стиле \"Лофт\", завлекает интересными и необычными деталями интерьера.\nГостеприимный персонал, приятная музыка, оригинальная подача блюд и разумное соотношение цены и качества", "https://yandex.ru/maps/org/grenok/1273999934/reviews/?ll=41.450989%2C52.723439&z=15", "https://yandex.ru/maps/org/grenok/1273999934/?ll=41.450989%2C52.723439&z=15", 1));
        courseList.add(new Course(6, "debut", "Кафе Дебют", "ул. Архиепископа Луки, 12", "5,0 ⭐", "600 ₽", "#00768a", "Кафе Дебют  предлагает вам окунуться в атмосферу вкусной еды и прохладных напитков. Здесь можно быстро и недорого перекусить как в одиночестве, так и с друзьями или семьей. Вы — настоящий фанат жареного мяса? Тогда вам может прийтись по душе выбор блюд в меню нашего кафе.", "https://yandex.ru/maps/org/debyut/1049336629/reviews/?ll=41.459077%2C52.718140&z=15", "https://yandex.ru/maps/org/debyut/1049336629/?ll=41.459077%2C52.718140&z=15", 2));
        courseList.add(new Course(7, "terrasa", "Кафе Терраса", "Совесткая ул., 99А", "4,3  ⭐", "900 ₽", "#aa8460", "Грандиозное место в самом центре города на крыше с собственной террасой,\n а так же с удивительно уютной обстановкой \n выступления с живой музыкой", "https://yandex.ru/maps/org/terrasa/35484424105/reviews/?ll=41.456484%2C52.724306&z=15", "https://yandex.ru/maps/org/terrasa/35484424105/?ll=41.456484%2C52.724306&z=15", 2));
        courseList.add(new Course(8, "xlebvino", "Кафе Хлеб и Винотека", "Совесткая ул., 119", "4,7 ⭐", "400 ₽", "#796d79", "Это особая атмосфера, которой пропитано все кругом.\nЗдесь собираются люди, которые хотят почувствовать вкус вина, вкус еды, вкус настоящей жизни.\n Не забудьте про хлеб. Потому что мы выпекаем, основываясь на старинных рецептах и лучших традициях. Запах хлеба, его вкус и хруст свежей корочки - это то удовольствие, которое не отпускает.", "https://yandex.ru/maps/org/khleb_i_vinoteka/1725875067/reviews/?ll=41.453502%2C52.733624&z=14", "https://yandex.ru/maps/org/khleb_i_vinoteka/1725875067/?ll=41.453502%2C52.733624&z=14", 2));
        courseList.add(new Course(9, "miteria", "Кафе Митерия", "Октябрьская ул., 11", "4,9 ⭐", "500 ₽", "#7a9867", "Кухня с мясным акцентом, где все ингредиенты проходят через живой огонь в испанском хоспер-гриле Mibrasa! Аккомпанируют блюдам вина со всех континентов от доступных домашних до редких экземпляров.", "https://yandex.ru/maps/org/miteriya/159327957402/reviews/?ll=41.452668%2C52.726188&z=14", "https://yandex.ru/maps/org/miteriya/159327957402/?ll=41.452668%2C52.726188&z=14", 2));
        courseList.add(new Course(10, "gorkiy", "Бар Горький Паб", "ул. Максима Горького, 16", "4,8 ⭐", "600 ₽", "#ae4b4c", "Пивной бар «Горький паб» пожалуй, самое пивное заведение в городе. Оно спрячет Вас в уютном полумраке от суматохи будней. Здесь нет спешки, не нужно думать, как ты выглядишь и во что одет , лишь уют, комфорт и демократическая атмосфера. ", "https://yandex.ru/maps/org/gorkiy_pab/1744135275/reviews/?ll=41.456771%2C52.719337&z=15", "https://yandex.ru/maps/org/gorkiy_pab/1744135275/?ll=41.456771%2C52.719337&z=15", 4));
        courseList.add(new Course(11, "slon", "Бар Слон и Солод", "Интернациональная ул., 22", "5,0 ⭐", "1000 ₽", "#77664a", "Паб с душевной и живой атмосферой\nНаша история про достойную, качественную и вкусную еду, отличное пиво и правильную атмосферу\nСобирайтесь вместе - мы за шумные и веселые посиделки!", "https://yandex.ru/maps/org/slon_i_solod/191842891390/reviews/?ll=41.452619%2C52.720875&z=14", "https://yandex.ru/maps/org/slon_i_solod/191842891390/?ll=41.452619%2C52.720875&z=14", 4));
        courseList.add(new Course(12, "garage", "Бар Гараж", "Совесткая ул., 81А", "4,3 ⭐", "800 ₽", "#02032a", "Бар «Гараж» в Тамбове - самое атмосферное заведение в городе. Спокойный и брутальный в будние дни, в выходные и праздники он превращается в драйвовое место. Шикарная кухня с огромным выбором пивных закусок, дискотеки 80-90х, диджейские вечеринки, Stand-up, живая музыка, вечера лаундж-вокалистов, латинские вечеринки, мальчишники, девичники, корпоративы, дни рождения и даже свадьбы - все это в Гараже!", "https://yandex.ru/maps/org/garazh/1358564009/reviews/?ll=41.458538%2C52.718725&z=14", "https://yandex.ru/maps/org/garazh/1358564009/?ll=41.458538%2C52.718725&z=14", 4));
        courseList.add(new Course(13, "nashapizza", "Пиццерия Наша Пицца", "Интернациональная ул., 22", "4,4 ⭐", "600 ₽", "#dccab2", "Пиццерия \"Наша пицца\" - оазис гастрономической радости, расположенный в самом сердце города. Вас ждет не только кулинарное путешествие по авторским блюдам, но и невероятная атмосфера исторического здания, создающая идеальный фон для необыкновенных воспоминаний.", "https://yandex.ru/maps/org/nasha_pitstsa/58268189921/reviews/?ll=41.452478%2C52.720746&z=15", "https://yandex.ru/maps/org/nasha_pitstsa/58268189921/?ll=41.452478%2C52.720746&z=15", 3));
        courseList.add(new Course(14, "papakarlo", "Пиццерия Папа Карло", "Державинская ул., 16", "4,9 ⭐", "300 ₽", "#321b10", "Папа Карло — это пиццерия, расположенная в самом центре города. Мы радуем своих гостей уютной, дружелюбной атмосферой и вкусной кухней с 2006 года!\nНаша пицца обязательно порадует вас отличным вкусом и приятной ценой.", "https://yandex.ru/maps/org/papa_karlo/1241729758/reviews/?ll=41.450336%2C52.724248&z=15", "https://yandex.ru/maps/org/papa_karlo/1241729758/?ll=41.450336%2C52.724248&z=15", 3));
        courseList.add(new Course(15, "pizzapasta", "Пиццерия Пицца&Паста", "ул. Коммунальная, 20/5", "4,9 ⭐", "700 ₽", "#b4a785", "Мы готовим вкуснейшую пиццу и пасту собственного производства с более чем 10 видами начинок. Наши цены и порции обязательно Вас порадуют!\nВ нашем зале царит семейная атмосфера, идеальная для проведения дней рождений, юбилеев, небольших корпоративов и других торжеств!", "https://yandex.ru/maps/org/pitstsa_pasta/91957047960/reviews/?ll=41.448833%2C52.722676&z=17", "https://yandex.ru/maps/org/pitstsa_pasta/91957047960/?ll=41.448833%2C52.722676&z=17", 3));
        courseList.add(new Course(16, "zharpizza", "Пиццерия ЖарПицца", " ул. Советская, 178.", "4,3 ⭐", "800 ₽", "#17120f", "Семейное кафе \"Жар-пицца\". Здесь вам ждет вкусная еда, уютный интерьер и детские развлечения. Отличный отдых для всей семьи.", "https://yandex.ru/maps/org/zhar_pitstsa/1064453332/reviews/?ll=41.451025%2C52.740168&z=14", "https://yandex.ru/maps/org/zhar_pitstsa/1064453332/?ll=41.451025%2C52.740168&z=14", 3));
        courseList.add(new Course(17, "arigato", "Суши-бар Аригато", " ул. Советская, 184.", "4,9 ⭐", "500 ₽", "#a9bbc0", "АРИГАТО́\nЯпонская, тайская и европейская кухни\uD83C\uDF63\uD83C\uDF64\uD83C\uDF74\uD83C\uDF5C\uD83C\uDF71", "https://yandex.ru/maps/org/arigato/1616849117/reviews/?ll=41.449566%2C52.742699&z=14", "https://yandex.ru/maps/org/arigato/1616849117/?ll=41.449566%2C52.742699&z=14", 5));
        courseList.add(new Course(18, "risoy", "Суши-бар Risoy", " ул. Советская, 70, корп.2", "4,8 ⭐", "1200 ₽", "#918f9c", "\nКафе RISOY приглашает Вас в гости приятно провести время в уютной обстановке за чашечкой ароматного чая или кофе, чтобы попробовать или насладиться вновь нашей продукцией – суши и роллами.", "https://yandex.ru/maps/org/risoy/1400229452/reviews/?ll=41.461849%2C52.712751&z=14", "https://yandex.ru/maps/org/risoy/1400229452/?ll=41.461849%2C52.712751&z=14", 5));
        courseList.add(new Course(19, "nashisushi", "Суши-бар Наши Суши", " ул. Советская, 81А", "4,7 ⭐", "700 ₽", "#6e4528", "«Наши суши» - ресторан для любителей японской кухни, уважающих философию и традиции приготовления национальных блюд. Интерьер ресторана погружает вас в атмосферу комфорта, расслабления и великолепных вкусовых ощущений.", "https://yandex.ru/maps/org/nashi_sushi/1126045191/reviews/?ll=41.458570%2C52.718651&z=15", "https://yandex.ru/maps/org/nashi_sushi/1126045191/?ll=41.458570%2C52.718651&z=15", 5));
        fullcoursesList.addAll(courseList);

        setCourseRecycler(courseList);
    }

    private void setCourseRecycler(List<Course> courseList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }



    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }

    public static void resetCourseList() {
        courseList.clear();
        courseList.addAll(fullcoursesList);
        courseAdapter.notifyDataSetChanged();
    }

    private static final int RESET_CATEGORY = -1;

    public static void showCourseByCategory(int category) {
        if (category == RESET_CATEGORY) {
            resetCourseList();
            return;
        }

        courseList.clear();
        courseList.addAll(fullcoursesList);

        List<Course> filterCourses = new ArrayList<>();

        for (Course c : courseList) {
            if (c.getCategory() == category)
                filterCourses.add(c);
        }

        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();
    }



}
