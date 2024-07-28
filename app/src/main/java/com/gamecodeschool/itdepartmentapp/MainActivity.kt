package com.gamecodeschool.itdepartmentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gamecodeschool.itdepartmentapp.AdmissionsActivity
import com.gamecodeschool.itdepartmentapp.CoursesActivity
import com.gamecodeschool.itdepartmentapp.FacultyStaffActivity
import com.gamecodeschool.itdepartmentapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.gamecodeschool.itdepartmentapp.MenuAdapter
import com.gamecodeschool.itdepartmentapp.MenuItem
import com.gamecodeschool.itdepartmentapp.SocialMediaActivity

class MainActivity : AppCompatActivity() {

    private lateinit var menuAdapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        val menuItems = listOf(
            MenuItem("Faculty/Staff Directory", R.drawable.ic_directory),
            MenuItem("Courses", R.drawable.ic_courses),
            MenuItem("Admissions", R.drawable.ic_admissions),
            MenuItem("Social Media", R.drawable.ic_social_media)
        )

        menuAdapter = MenuAdapter(menuItems) { position ->
            when (position) {
                0 -> startActivity(Intent(this, FacultyStaffActivity::class.java))
                1 -> startActivity(Intent(this, CoursesActivity::class.java))
                2 -> startActivity(Intent(this, AdmissionsActivity::class.java))
                3 -> startActivity(Intent(this, SocialMediaActivity::class.java))
            }
        }

        val recyclerView: RecyclerView = findViewById(R.id.menu_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = menuAdapter

        val fabEmail: FloatingActionButton = findViewById(R.id.fab_email)
        fabEmail.setOnClickListener {
            sendEmailToHOD()
        }
    }

    private fun sendEmailToHOD() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:hod@ucc.edu.jm")
            putExtra(Intent.EXTRA_SUBJECT, "Query for IT Department HOD")
        }
        startActivity(Intent.createChooser(intent, "Send email"))
    }
}