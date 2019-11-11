# Ikaten2019
jsonファイルを書き換えると自動的に描写されます  
[プロジェクションマッピング](https://akatsuki1910.github.io/Ikaten2019/index.html)  
## jsonの書き方
|変数名|値|詳細|
|--|--|--|
| src | 画像 | pic/*.png |
| num | 種類 | 1:魚,2:浮遊 |
| dir | 向き | 0:右,1:左 |

## 表示部分
### index.html
表示させるもの。F11のあとF5
### index.js
動く部分。three.js+pixi.js
### back.js
背景画像がかわる部分。重いと動かない。pixi.js
### main.css
canvasの体裁を整えるもの。
### pic.json
pictureが入るもの。
### 使用ライブラリ
- jquery-3.3.1.min.js
- pixi.min.js
- three.min.js
# java
## 注意事項
外部APIが足りてないのでHPからDLしてください
1週間で錬成したのでごみごみ
仕様変更が重なりスパゲッティ
私ににもどうなってるのかよくわからない
## 足りてない外部API
- Jackson
- Spire.pdf]

---

## Main
GUIを動かすだけ
## Window
最初の画面のGUI全部制御してる
誰が見てもくそコード
## PreWindow
画像編集機能のGUI制御
上に同じくくそコード
## Previwe
画像の回転処理しかしてない
360度対応
## Json
Jsonの読み書き
## Trimming
画像のトリミング処理
## Conversion
透過処理
## PdfToPng
PDFから画像を取得してPNG形式で保存する
## MLisner
マウスクリックの取得

---

## 使い方
1. 一番上に作業フォルダを入力
2. loadを押す
3. 2段目にPDFのファイル名を入力
4. getを押す(enterでも可)
5. 新しく出たウィンドウで画像の回転角を選択
6. 画像をクリックして、上下左右のボタンを押すことでトリミング
7. successで編集を確定

### その他の説明
- jsonから削除したいときは、loadボタンを押したのちにドロップダウンから消したいものを選択してremoveボタンをクリック
- jsonについただけする場合は、一番下にpngの名前を入力してaddボタンをクリック
- 回転が必要ない場合はボタンを押す必要なし(やり直し用ボタンのため)
- 画像編集を間違った場合は、回転ボタンを再度クリック
- numやdirはランダムで選択されてます
