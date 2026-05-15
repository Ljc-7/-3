项目名称：Android CameraX 实验（CameraXApp）

实验信息
课程：Android 开发 / Kotlin 编程
学生姓名：林觉川
学号：121052023015
实验日期：2026年5月15日

项目简介
本项目基于 Jetpack CameraX 库构建相机应用，实现以下功能：

实时相机预览（Preview）

拍照并保存图片（ImageCapture）

录制视频并保存（VideoCapture）

扩展：实时图像分析（ImageAnalysis），计算每帧平均亮度

环境要求

Android Studio Hedgehog+

最低 SDK 21（Android 5.0）

真机（需后置摄像头及麦克风）

Kotlin 1.9+

CameraX 1.5.0-alpha06

主要依赖（build.gradle 片段）
dependencies {
def camerax_version = "1.5.0-alpha06"
implementation "androidx.camera:camera-core:
ca
m
e
r
a
x
v
e
r
s
i
o
n
"
i
m
p
l
e
m
e
n
t
a
t
i
o
n
"
a
n
d
r
o
i
d
x
.
c
a
m
e
r
a
:
c
a
m
e
r
a
−
c
a
m
e
r
a
2
:
camerax 
v
​
 ersion"implementation"androidx.camera:camera−camera2:camerax_version"
implementation "androidx.camera:camera-lifecycle:
c
a
m
e
r
a
x
v
e
r
s
i
o
n
"
i
m
p
l
e
m
e
n
t
a
t
i
o
n
"
a
n
d
r
o
i
d
x
.
c
a
m
e
r
a
:
c
a
m
e
r
a
−
v
i
d
e
o
:
camerax 
v
​
 ersion"implementation"androidx.camera:camera−video:camerax_version"
implementation "androidx.camera:camera-view:
c
a
m
e
r
a
x
v
e
r
s
i
o
n
"
i
m
p
l
e
m
e
n
t
a
t
i
o
n
"
a
n
d
r
o
i
d
x
.
c
a
m
e
r
a
:
c
a
m
e
r
a
−
m
l
k
i
t
−
v
i
s
i
o
n
:
camerax 
v
​
 ersion"implementation"androidx.camera:camera−mlkit−vision:camerax_version"
}

功能说明

相机预览：使用 PreviewView 显示实时画面，自动选择后置摄像头。

拍照：点击“拍照”按钮保存图片到 Pictures 目录。

录像：点击“开始录像”录制（含音频），点击“停止录像”保存到 Movies 目录。

图像分析：实时显示画面平均亮度值（0-255）。

使用步骤

git clone https://github.com/你的用户名/CameraXApp.git

用 Android Studio 打开项目，同步 Gradle。

连接真机，运行应用。

授予相机和录音权限。

测试拍照、录像、亮度分析功能。

截图位置



代码结构
MainActivity.kt # 绑定用例、按钮事件
BrightnessAnalyzer.kt # 亮度分析器（可选）
activity_main.xml # 布局文件
AndroidManifest.xml # 权限声明

关键代码（简要）
绑定用例：
val cameraProvider = ProcessCameraProvider.getInstance(this).get()
val preview = Preview.Builder().build()
val imageCapture = ImageCapture.Builder().build()
val videoCapture = VideoCapture.Builder().build()
cameraProvider.bindToLifecycle(this, CameraSelector.DEFAULT_BACK_CAMERA, preview, imageCapture, videoCapture)

拍照：
imageCapture.takePicture(...)

录像：
videoCapture.startRecording(...)
videoCapture.stopRecording()

图像分析：
class BrightnessAnalyzer : ImageAnalysis.Analyzer { ... }

遇到的问题及解决

录像无声：添加 RECORD_AUDIO 权限。

Android 10+ 保存失败：使用 getExternalFilesDir 避开分区存储限制。

分析器 UI 更新崩溃：用 Handler 切换到主线程。

参考教程
CameraX 官方文档：https://developer.android.com/training/camerax
CameraX 入门指南：https://developer.android.com/camera/camerax/getting-started

仓库地址
https://github.com/你的用户名/CameraXApp
