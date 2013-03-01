information-Security-lasb
=========================

<h1>labs</h1>
<h3>Установка git</h3>
<span>
Для Ubuntu - sudo apt-get install git
</span><br/>
<span>
Для остального - <a href="http://www.google.ru/">google.ru ;)</a>
</span><br/><br/><br/>
<h3>Полчить копию репозитория:</h3>
<span>После установки git нужно получить копию репозитория,</br>это делается так:<br/><br/>
git clone git@github.com:nik0143v/information-Security-lasb.git
</span><br/>
<span style="font-size:16">не забудь прописать публичные ssh ключи у себя в профиле на github</span>
<h3>Конфигурирование репозитория:</h3>
<span>
В каком-нибудь редакторе открой {repository folder}/.git/config
</span><br/><br/>
<span>
Пример конфига:<br/><br/>
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
