package id.ac.uny.riset.darling.menu.panduan

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.github.paolorotolo.appintro.AppIntro2
import com.github.paolorotolo.appintro.AppIntroFragment
import id.ac.uny.riset.darling.R
import id.ac.uny.riset.darling.menu.main.MainActivity

class PanduanActivity: AppIntro2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addSlide(AppIntroFragment.newInstance("Survey Diri",
                "Coba Survey melalui aplikasi MeetU", R.drawable.ic_survey, ContextCompat.getColor(baseContext, R.color.pink_100)));
        addSlide(AppIntroFragment.newInstance("Task Harian",
                "Tingkatkan kualitas dirimu dengan memperhatikan task yang diberikan secara harian", R.drawable.ic_text, ContextCompat.getColor(baseContext, R.color.brown_100)));
        addSlide(AppIntroFragment.newInstance("Grafik Penilaian",
                "Ukur kemampuan dirimu melalui grafik penilaian survey", R.drawable.ic_graph, ContextCompat.getColor(baseContext, R.color.blue_100)));

        setSlideOverAnimation()

    }

    override fun onDonePressed() {
        super.onDonePressed()
        startActivity(Intent(baseContext, MainActivity::class.java))
        finish()
    }
}