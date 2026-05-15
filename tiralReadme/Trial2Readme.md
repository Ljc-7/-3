# 实验2：构建 Kotlin 应用并使用 Compose 布局

## 实验信息
- 学生姓名：林觉川
- 学号：121052023015
- 实验日期：2026年5月15日
- 开发环境：Android Studio Hedgehog | Kotlin 1.9 | Compose BOM 2024.02.00

## 项目简介
本项目为 Android 开发课程实验，实现了三个任务：
1. 创建首个 Kotlin + Compose 应用，并成功运行。
2. 实践 Compose 基础布局（Column、Button、状态管理）。
3. 设计面向 AI 应用的界面（顶部栏、相机预览占位、结果卡片、四个功能按钮）。

## 运行环境
- Android SDK：API 21 及以上
- 编译工具：Gradle 8.0+
- 测试设备：模拟器 Pixel 4 API 30 或真机 Android 10+

## 如何运行
1. 使用 Android Studio 打开本项目。
2. 等待 Gradle 同步完成。
3. 连接 Android 设备或启动模拟器。
4. 点击运行按钮（绿色三角形）。

## 界面截图
### 任务一：首个应用运行截图
![任务一截图](screenshots/task1.jpg)

### 任务二：Compose 基础布局截图
![任务二截图](screenshots/task2.jpg)

### 任务三：AI 应用完整界面截图
![任务三截图](screenshots/task3.jpg)

## 主要代码结构
- `MainActivity.kt`：包含三个 Composable 函数（GreetingScreen、AiCameraScreen）。
- 使用 `Column`、`Row`、`Box`、`Card`、`TopAppBar` 等 Compose 组件。
- 状态管理使用 `remember` + `mutableStateOf`。

## 遇到的问题及解决
- 问题：预览区固定高度后，按钮在小屏幕被挤出。
  解决：为预览区添加 `Modifier.weight(1f)`，外层 Column 使用 `verticalArrangement = Arrangement.SpaceBetween`。

## 参考教程
- [Kotlin Koans](https://play.kotlinlang.org/koans/overview)
- [Jetpack Compose 官方文档](https://developer.android.com/jetpack/compose)

## 仓库地址
[GitHub链接](https://github.com/你的用户名/仓库名)
