package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        calculateBtn.setOnClickListener {
            var s= true
            outPutTxt.text=""

            if(weightInput.text.toString().isEmpty() ||heightInput.text.toString().isEmpty()){
                Toast.makeText(this, "لطفا همه موارد را پر کنید", Toast.LENGTH_LONG).show()

            }else {
                if(heightInput.text.toString().toFloat() >=3){
                    Toast.makeText(this, "مطمئنی قدت رو به متر زدی؟", Toast.LENGTH_LONG).show()
                    s=false
                }
                if(weightInput.text.toString().length >3 ){
                    Toast.makeText(this, "مطمئنی ورزنت رو به کیلوگرم زدی؟", Toast.LENGTH_LONG).show()
                    s=false
                }
                if(s) {

                    var weight = weightInput.text.toString().toFloat()
                    var height = heightInput.text.toString().toFloat()

                    var bmiNum = calculate(weight, height)

                    var normalW= 21*(height*height)
                    var status = ""
                    if (bmiNum >= 18.5 && bmiNum <= 25) {
                        status = "نرمال و سلامتی!"

                    } else if (bmiNum > 25) {
                        var over= String.format("%.1f", weight-normalW)
                        status = " یکم چاقی...حداقل "+ over+ " کیلوگرم کم کن"

                    } else if (bmiNum < 18.5) {
                        var less= String.format("%.1f", normalW- weight)
                        status = "یکم لاغری... حداقل "+less+ "کیلوگرم زیاد کن"

                    }
                    outPutTxt.text = "عدد BMI شما: " + String.format("%.2f", bmiNum)+
                            "\n" + status
                }
            }
        }

    }
    fun calculate(weight: Float, height: Float) :Float{
        return weight/ (height*height)
    }
}