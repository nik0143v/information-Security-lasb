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
пример конфига
в каком-нибудь редакторе открой {repository folder}/.git/config
</span><br/>
[core]
	repositoryformatversion = 0
	filemode = true
	bare = false
	logallrefupdates = true
[remote "origin"]
	fetch = +refs/heads/*:refs/remotes/origin/*
	url = git@github.com:nik0143v/information-Security-lasb.git
[gitflow "branch"]
	master = master
	develop = develop
[branch "develop"]
	remote = origin
	merge = refs/heads/develop
[gitflow "prefix"]
	feature = feature/
	release = release/
	hotfix = hotfix/
	support = support/
	versiontag = 
[alias]
  co = checkout
  ci = commit
  st = status
  br = branch
  hist = log --pretty=format:\"%h %ad | %s%d [%an]\" --graph --date=short
  type = cat-file -t
  dump = cat-file -p
[color]
	ui = true
[branch "master"]
	remote = origin
	merge = refs/heads/master

основные комманды да и вообще работа с git
http://githowto.com/ru

старайся делать комиты чаще.
работай со своей веткой.
