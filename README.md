# CheckCodeEditText [![](https://jitpack.io/v/hlllmr1314/CheckCodeEditText.svg)](https://jitpack.io/#hlllmr1314/CheckCodeEditText)
高仿钉钉验证码输入框 
 
## Demo
![Demo picture](https://raw.githubusercontent.com/hlllmr1314/CheckCodeEditText/master/stepper-example.gif)

 
# Usage
Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
	
Step 2. Add the dependency
```
	dependencies {
	        compile 'com.github.hlllmr1314:CheckCodeEditText:1.0'
	}
```

Step 3. Add the `com.haley.checkcodeview.CheckCodeEditText` to your layout XML file.
```XML
  <com.haley.checkcodeview.CheckCodeEditText
        android:id="@+id/checkcode_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
         />
```

Step 4. add Listener and get text
```
	 this.codeEditText = (CheckCodeEditText) findViewById(R.id.checkcode_view);
	 codeEditText.addCompleteListener(this);//add Listener
	 codeEditText.getText();//get text
```

## License
```

   Copyright {2016} {haley of copyright owner}

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
