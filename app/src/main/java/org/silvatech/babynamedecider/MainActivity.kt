package org.silvatech.babynamedecider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import com.google.android.gms.ads.MobileAds;


class MainActivity : AppCompatActivity() {

    val babyNameList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, "ca-app-pub-9497317358583649~2568968579")

        decideBtn.setOnClickListener {

            val random = Random()
            if (babyNameList.isEmpty()){
                Toast.makeText(this, "List is Empty, Please Add Names", Toast.LENGTH_LONG).show()
            }else{
                val randomFood = random.nextInt(babyNameList.count())
                selectedBabyNameText.text = babyNameList[randomFood]
            }
        }

        addBabyNameBtn.setOnClickListener {
            val newName = addBabyNameTxt.text.toString()

            if(newName.isBlank()){
                Toast.makeText(this, "No Blanks Allowed", Toast.LENGTH_LONG).show()
            }else{
                babyNameList.add(newName)
                addBabyNameTxt.text.clear()
            }

        }

    }
}
