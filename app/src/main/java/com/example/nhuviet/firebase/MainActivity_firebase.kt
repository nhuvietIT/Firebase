package com.example.nhuviet.firebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.FractionRes
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main_firebase.*

class MainActivity_firebase : AppCompatActivity() {


    var database : DatabaseReference

    init {
        database = FirebaseDatabase.getInstance().reference
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_firebase)
//        database.child("MonHoc").setValue("lập trình may tính")
//        database.child("Danhsachkhoahoc").push().setValue("IOS")

        bt_1.setOnClickListener{
            database.child("Danhsachkhoahoc").push().setValue(ed_1.text.toString())
            onStart()
        }

        ///////////////////////////////////////////////////////////////////
        database.child("MonHoc").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onDataChange(p0: DataSnapshot?) {
                var tenmonhoc : String = p0?.getValue().toString()
                tv_1.text = tenmonhoc
            }
        })
        /////////////////////////////////////////////////////////////////////////////////////////
         database.child("Danhsachkhoahoc").addChildEventListener(object : ChildEventListener{
             override fun onCancelled(p0: DatabaseError?) {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
             }

             override fun onChildMoved(p0: DataSnapshot?, p1: String?) {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
             }

             override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
             }

             override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                 var ten : String = p0?.getValue().toString()


                 tv_2.append(ten + "\n")
             }

             override fun onChildRemoved(p0: DataSnapshot?) {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
             }


         })

    }

}
