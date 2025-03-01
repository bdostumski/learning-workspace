# Custom Themes

THEMES=$HOME/.zshrc.d/zinit.d/themes

# add powerlevel10k theme
zinit ice depth=1; zinit light romkatv/powerlevel10k

# prompt pure theme using (p10k plugin)
[[ ! -f $THEMES/zsh-themes/.pure_theme.zsh ]] || source $THEMES/zsh-themes/.pure_theme.zsh

# custom ls colors | and prebuild with vivid plugin
if [ -d $THEMES/ls-color-schemes ]; then
	export LS_COLORS="$(cat $THEMES/ls-color-schemes/snazzy)"
else
	export LS_COLORS="di=36:fi=0:ln=34:mh=00:pi=33:so=35:do=35:bd=33;1:cd=33;1:or=31;1:mi=0:su=31:sg=31:ca=31:tw=32:ow=32:st=34;1:ex=92"
fi

# completion styling
zstyle ':completion:*' list-colors ${(s.:.)LS_COLORS}
zstyle ':completion:*' matcher-list 'm:{a-z}={A-Z}'
zstyle ':completion:*' menu no
zstyle ':fzf-tab:complete:cd:*' fzf-preview 'ls --color $realpath'

# fzf shell integration
eval "$(fzf --zsh)"

# Notes:
# To create new prompt configuration, run `p10k configure`
