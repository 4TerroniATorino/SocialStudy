here="`dirname \"$0\"`"

cd "$here"
cd ..
git add --all .
git commit -a -m "Update"
git push origin master