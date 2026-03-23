# Todo App 仕様書

## 機能
- Todo の作成・取得・更新・削除
- 完了/未完了のトグル

## API
| Method | Path | 説明 |
|--------|------|------|
| POST | /api/todos | 作成 |
| GET | /api/todos | 一覧 |
| GET | /api/todos/{id} | 1件取得 |
| PUT | /api/todos/{id} | 更新 |
| DELETE | /api/todos/{id} | 削除 |
| PATCH | /api/todos/{id}/toggle | 完了切替 |

## Todo項目
| フィールド | 型 | 説明 |
|-----------|-----|------|
| id | Long | 自動採番 |
| title | String | タイトル（必須） |
| description | String | 説明 |
| completed | boolean | 完了フラグ |
| createdAt | LocalDateTime | 作成日時 |
| updatedAt | LocalDateTime | 更新日時 |
