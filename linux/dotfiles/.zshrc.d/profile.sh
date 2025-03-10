#
# CUSTOM CONFIGURATIONS & THEMES
#

# -----------------
# TERMINAL THEME 
# -----------------
# Notes:
# To create new prompt configuration, run `p10k configure`
# ---------- 
# Theme home directory path
THEMES=$HOME/.zshrc.d/config.d/themes
# ---------- 
# Add powerlevel10k theme
zinit ice depth=1; zinit light romkatv/powerlevel10k
# ---------- 
# Setup terminal theme
local CLASSIC_THEME='.classic_theme.sh'
local PURE_THEME='.pure_theme.sh'
# Prompt pure theme using (p10k plugin)
[[ ! -f $THEMES/shell/$PURE_THEME ]] || source $THEMES/shell/$PURE_THEME

# -----------------
# LS COLOR SCHMES
# -----------------
# ls color scheme names
local ALABASTER_DARK='alabaster_dark'
local AYU='ayu'
local CATPPUCCIN_FRAPE='catppuccin-frappe'
local CATPPUCCIN_LATE='catppuccin-latte'
local CATPPUCCIN_MOCHA='catppuccin-mocha'
local DRACULA='dracula'
local GRUVBOX_DARK='gruvbox-dark'
local GRUVBOX_DARK_HARD='gruvbox-dark-hard'
local GRUVBOX_DARK_SOFT='gruvbox-dark-soft'
local GRUVBOX_LIGHT='gruvbox-light'
local GRUVBOX_LIGHT_HARD='gruvbox-light-hard'
local GRUVBOX_LIGHT_SOFT='gruvbox-light-soft'
local ICEBERG_DARK='iceberg-dark'
local JELLYBEANS='jellybeans'
local LAVA='lava'
local MODUS_OPERANDI='modus-operandi'
local MOLOKAI='molokai'
local NORD='nord'
local ONE_DARK='one-dark'
local ONE_LIGHT='one-light'
local ROSE_PINE='rose-pine'
local ROSE_PINE_DAWN='rose-pine-dawn'
local ROSE_PINE_MOON='rose-pine-moon'
local SNAZZY='snazzy'
local SOLARIZED_DARK='solarized-dark'
local SOLARIZED_LIGHT='solarized-light'
local TOKYONIGHT_MOON='tokyonight-moon'
local TOKYONIGHT_NIGHT='tokyonight-night'
local TOKYONIGHT_STORM='tokyonight-storm'
local ZENBURN='zenburn'
# ---------- 
# Choose ls color scheme
local LS_COLOR_SCHEME="$THEMES/ls/$SNAZZY"
# ---------- 
# Setup vivid plugin color scheme | Else use default custom color scheme
if [ -d $LS_COLOR_SHEME ]; then
	export LS_COLORS="$(cat $LS_COLOR_SCHEME)"
else
	export LS_COLORS="di=36:fi=0:ln=34:mh=00:pi=33:so=35:do=35:bd=33;1:cd=33;1:or=31;1:mi=0:su=31:sg=31:ca=31:tw=32:ow=32:st=34;1:ex=92"
fi

# -----------------
# FZF CONFIGURATIONS
# -----------------
# Completion styling
zstyle ':completion:*' list-colors ${(s.:.)LS_COLORS} 
zstyle ':completion:*' matcher-list 'm:{a-z}={A-Z}'
zstyle ':completion:*' menu no
zstyle ':fzf-tab:complete:cd:*' fzf-preview 'ls --color $realpath'
# ---------- 
# fzf shell integration
eval "$(fzf --zsh)"
