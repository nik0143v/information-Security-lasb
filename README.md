information-Security-lasb
=========================

labs
<span>
Для того, чтобы начать работать с git над нашими лабами тебе нужно
установить себе гит.</span><br/>
<span>
Для Ubuntu - sudo apt-get install git
</span><br/>
<span>
Для остального - google.ru ;)
</span><br/><br/><br/>
<span>
Конфигурирование репозитория:<br/>
В каком-нибудь редакторе открой {repository folder}/.git/config
</span><br/>
<span>
Пример конфига:<br/>
[core]<br/>
	repositoryformatversion = 0<br/>
	filemode = true<br/>
	bare = false<br/>
	logallrefupdates = true<br/>
[remote "origin"]<br/>
	fetch = +refs/heads/*:refs/remotes/origin/*<br/>
	url = git@github.com:nik0143v/information-Security-lasb.git<br/>
[gitflow "branch"]<br/>
	master = master<br/>
	develop = develop<br/>
[branch "develop"]<br/>
	remote = origin<br/>
	merge = refs/heads/develop<br/>
[gitflow "prefix"]<br/>
	feature = feature/<br/>
	release = release/<br/>
	hotfix = hotfix/<br/>
	support = support/<br/>
	versiontag = <br/>
[alias]<br/>
  co = checkout<br/>
  ci = commit<br/>
  st = status<br/>
  br = branch<br/>
  hist = log --pretty=format:\"%h %ad | %s%d [%an]\" --graph --date=short<br/>
  type = cat-file -t<br/>
  dump = cat-file -p<br/>
[color]<br/>
	ui = true<br/>
[branch "master"]<br/>
	remote = origin<br/>
	merge = refs/heads/master<br/>
</span><br/>
<h3>Справочник:</h3><br/>
<a href="http://githowto.com/ru">http://githowto.com/ru</a>
<h3>Рекомендации:</h3><br/>
<span>
1. Старайся делать комиты чаще.<br/>
2. Работай со своей веткой.<br/>
</span>
