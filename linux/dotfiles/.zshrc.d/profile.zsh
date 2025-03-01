# Prompt Theme & Keybindings

# custom themes
# To create new prompt configuration, run `p10k configure`

# add powerlevel10k theme
zinit ice depth=1; zinit light romkatv/powerlevel10k

# prompt pure theme using (p10k plugin)
[[ ! -f ~/.zshrc.d/zinit.d/themes/zsh-themes/.pure_theme.zsh ]] || source ~/.zshrc.d/zinit.d/themes/zsh-themes/.pure_theme.zsh

# custom ls colors | and prebuild with vivid plugin
if [ -d ~/.zshrc.d/zinit.d/themes/ls-color-schemes ]; then
	export LS_COLORS="$(cat ~/.zshrc.d/zinit.d/themes/ls-color-schemes/snazzy)"
else
	export LS_COLORS="di=36:fi=0:ln=34:mh=00:pi=33:so=35:do=35:bd=33;1:cd=33;1:or=31;1:mi=0:su=31:sg=31:ca=31:tw=32:ow=32:st=34;1:ex=92"
fi

