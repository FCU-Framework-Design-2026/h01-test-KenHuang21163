[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/YdiMaToP)
# H1: OOP

## 🎯 任務說明

### ✍ 練習 2.4.3：象棋翻棋遊戲
> [!TIP]
> * 考慮一個象棋翻棋遊戲，32 個棋子會隨機的落在 4*8的棋盤上。透過 Chess 的建構子產生這些棋子並隨機編排位置，再印出這些棋子的名字、位置
> 	* ChessGame
> 	    * void showAllChess(); 
> 	    * void generateChess();
> 	* Chess: 
> 	    * Chess(name, weight, side, loc); 
> 	    * String toString();	
> * 同上， 
>     * ChessGame 繼承一個抽象的 AbstractGame; AbstractGame 宣告若干抽象的方法：
>         * setPlayers(Player, Player)
>         * boolean gameOver()
>         * boolean move(int location)
> * 撰寫一個簡單版、非 GUI 介面的 Chess 系統。使用者可以在 console 介面輸入所要選擇的棋子的位置 (例如 A2, B3)，若該位置的棋子未翻開則翻開，若以翻開則系統要求輸入目的的位置進行移動或吃子，如果不成功則系統提示錯誤回到原來狀態。每個動作都會重新顯示棋盤狀態。
> * 規則：請參考 [這裏](https://zh.wikipedia.org/wiki/%E6%9A%97%E6%A3%8B#%E5%8F%B0%E7%81%A3%E6%9A%97%E6%A3%8B)
> 
> ```
>    1   2   3  4   5  6   7   8
> A  ＿  兵  ＿  車  Ｘ  ＿  象  Ｘ
> B  Ｘ  ＿  包  Ｘ  士  ＿  馬  Ｘ   
> C  象  兵  Ｘ  車  馬  ＿  ＿  將 
> D  Ｘ  包  ＿  士  兵  Ｘ  ＿  Ｘ  
> ```


## 作業繳交規範

* 必須有原始檔與報告檔。
* 報告檔必須為 PDF(不可為 Word)，內容包含
    * 題目 (可從本檔案複製)
    * 設計方法概述
    * 程式、執行畫面及其說明
    * AI 使用狀況與心得 (如果有使用 AI)
        * 使用層級：
          * (層級1) 僅用來除錯 
          * (層級2) 用來除錯，且改善功能、架構
          * (層級3) 一開始就使用，搭配局部的自己撰寫
          * (層級4) 全程使用 AI
        * 概述你和 AI 互動的次數與內容
          * 除錯、功能提升、學習、prompt 設計
        * 你手動(沒有用AI)的部份
        * 心得（AI的實用性、限制、對你學習的影響）
          * 例如反思：使用 AI 幫你省下了哪些程式？澄清了哪些觀念？你做了哪些查證發現AI的錯誤？它是否阻礙了你對某個 OOP 觀念的理解？
    * 報告檔需注意可讀性，特別是程式碼的呈現，建議使用 Markdown code block。畫面剪貼放置於 `img/`, 在報告檔 (`report.md`) 中引用。
    * 將 `report.md` 轉換為 PDF 格式: `report.pdf`
* 直接用 Github classroom 提交
  * 記得如果要透過 git add 把要提交的檔案 (src 下的 .java), img 下的截圖檔, `report.pdf` 等檔案加進去，而且要 commit, push。


## 🚀 如何領取與繳交 (First-time Guide)

### 第一步：領取作業
1. 點擊 [GitHub Classroom](https://classroom.github.com/a/ND9cMvSo) 連結。
2. **選取你的名字**：進入名單頁面後，找到並點擊你的學號/姓名（請務必看清楚，不要點到同學的）。
3. **接受作業**：點擊 "Accept this assignment"。
4. **等待 Repository 建立**：畫面會顯示正在準備你的專案，重新整理後你會得到一個專屬的 GitHub 網址（例如 `2026-swfw-hw01-yourname`）。

### 第二步：下載並開發
1. **Clone 專案**：複製你的 GitHub 專案網址，在本地端使用 Git Clone 或是直接在 IntelliJ IDEA 選取 "Get from VCS"。
2. **載入 Maven**：打開專案後若看到右下角有 "Load Maven Project"，請點擊它。
3. **進行開發**：依照「任務說明」完成程式實作並撰寫報告 PDF。

### 第三步：提交與上傳
1. **Commit & Push**：完成後，將你的原始碼與報告 PDF 進行 Git Commit 與 Push。請確認你的程式碼已上傳到 GitHub。
2. **驗證**：回到 GitHub 網頁版，確認是否有看到你剛上傳的檔案。
3. **繳交完成**：GitHub Classroom 會自動追蹤你的 Commit，Push 成功即視為繳交。

## 📝 繳交規範
* 截止日期：2026/3/16 12:00
* 嚴禁繳交 `.idea` 或 `target` 資料夾。（.gitignore 已經有限制）
