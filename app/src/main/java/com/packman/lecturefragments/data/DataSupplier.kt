package com.packman.lecturefragments.data

class DataSupplier {
    //Data for Android Studio only just for example
    fun getData(): List<Topic> {
        return listOf(
            Topic(
                name = "What is it?",
                details = "Android Studio is the official[7] integrated development environment (IDE) for Google's Android operating system, built on JetBrains' IntelliJ IDEA software and designed specifically for Android development.[8] It is available for download on Windows, macOS and Linux based operating systems.[9][10] It is a replacement for the Eclipse Android Development Tools (ADT) as the primary IDE for native Android application development.\n" +
                    "\n" +
                    "Android Studio was announced on May 16, 2013 at the Google I/O conference. It was in early access preview stage starting from version 0.1 in May 2013, then entered beta stage starting from version 0.8 which was released in June 2014.[11] The first stable build was released in December 2014, starting from version 1.0.[12]\n" +
                    "\n" +
                    "Since 7 May 2019, Kotlin is Google’s preferred language for Android app development.[13] Still, other languages are supported, including by Android Studio."
            ),

            Topic(
                name = "Features",
                details = "The following features are provided in the current stable version:[14][15]\n" +
                    "\n" +
                    "Gradle-based build support\n" +
                    "Android-specific refactoring and quick fixes\n" +
                    "Lint tools to catch performance, usability, version compatibility and other problems\n" +
                    "ProGuard integration and app-signing capabilities\n" +
                    "Template-based wizards to create common Android designs and components\n" +
                    "A rich layout editor that allows users to drag-and-drop UI components, option to preview layouts on multiple screen configurations[16]\n" +
                    "Support for building Android Wear apps\n" +
                    "Built-in support for Google Cloud Platform, enabling integration with Firebase Cloud Messaging (Earlier 'Google Cloud Messaging') and Google App Engine[17]\n" +
                    "Android Virtual Device (Emulator) to run and debug apps in the Android studio."
            ),

            Topic(
                name = "System requirements",
                details = "Windows XP or later\n" +
                    "Mac OS X 10.8.5 or later\n" +
                    "GNOME, KDE or Unity desktop on Ubuntu or Fedora or GNU/Linux Debian\n" +
                    "RAM\t3 GB RAM minimum, 4 GB RAM recommended\n" +
                    "Disk space\t500 MB disk space\n" +
                    "Space for Android SDK\tAt least 1 GB for Android SDK, emulator system images, and caches\n" +
                    "JDK version\tJava Development Kit (JDK) 7 or higher\n" +
                    "Screen resolution\t1280×800 minimum screen resolution"
            )
        )
    }
}