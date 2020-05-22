<img src="https://zuper.co/img/logo_trans.png" height="35" alt="Zuper">

### Zuperform helps you maintain compliance, create a zuper safe environment for your team and your customers.

Zuperform is open for signup at [ZuperCC](https://zuper.co) . You can signup, choose your industry vertical and use an existing template to quickly create complaince checklists.

Zuperform Android SDK let's you add this feature to your existing app with minimal effort. Once you are signed up, just follow the below steps to quickly have this feature embedded in your app.

An iOS variant is also available at [Zuperform-iOS](https://github.com/ZupersoftSolutions/ZuperForms_iOS_sdk)

#### Requirements
- Zuperform supports API 21 and above.

#### Installation
1. To add Zuperform to your app, just add the below dependency to your app's `build.gradle` file
```groovy
dependencies {
    implementation 'co.zuper.android:zuperform:1.0.9'
}
```

2. Initialize `Zuperform` using the Application Context and the company data
```kotlin
ZuperForm.init(
    applicationContext,
    ZuperFormConfig(
        COMPANY_ID,
        COMPANY_NAME,
        COMPANY_LOGO_URL
    )
)
```

#### Get Started
There are multiple ways to launch ZuperForm.

>NOTE: Users will be requested to login once by OTP mechanism using their email. We'll store the necessary data for future use.

1. Fire & forget - The user will be taken to Form Listing and can proceed subitting a form. You can do this by,
```kotlin
ZuperForm.launch()
```

2. You can directly take an user to a particular form using the form UID and get the result for the submission usign `ZuperForm.showForm()`
```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Launch Zuperform whenever required
        fabButton.setOnClickListener {
              ZuperForm.showForm(
                  this, // Activity
                  1234, // Request Code
                  "4b7d81c0-83e4-11ea-bdff-3b74ec04e036", // Form UID
                  "Custom Form" // Form Name
              )
        }
    }

    // Handle the result in OnActivityResult
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1234){
            if(resultCode== Activity.RESULT_OK){
                val formResult = data?.getParcelableExtra<FormResult>(ZuperForm.FORM_RESULT)
                if(formResult!=null){
                    Log.d("Form Name: " + formResult.formName)
                    Log.d("Form Submission UID: " + formResult.formSubmissionRefId)
                    Log.d("Total Questions: " + formResult.formItems.size)
                }
            }
        }
    }
}
```

Upon logout, you can logout from Zuperform by
```kotlin
ZuperForm.logout()
```
That's it!

#### Permissions
We include the following permissions in the library

1. INTERNET Permission - To make network requests
```
<uses-permission android:name="android.permission.INTERNET" />
```

2. CAMERA & WRITE_EXTERNAL_STORAGE - For Image Picker form type
```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.CAMERA" />
```

To know more about what we do at Zuper, please check us at [zuper.co](https://zuper.co)
