cd %~dp0
cd ..
git add --all .
git commit -a -m "Update"
git push openshift master