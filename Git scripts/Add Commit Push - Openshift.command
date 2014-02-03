here="`dirname \"$0\"`"

cd "$here"
git add --all .
git commit -a -m "Update"
git push openshift master