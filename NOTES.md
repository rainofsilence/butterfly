# 注意事项

## BINARY

mysql 大小写不敏感 如果想大小写完全匹配 需要加上关键字 BINARY

```mysql
select count(1) from user_info where BINARY `username` = 'Hello';
```