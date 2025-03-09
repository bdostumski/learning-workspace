# Plugins
# Load the plugin manager


function is_zinit_installed() {
	local plugin_name=$1
	[[ -d "$HOME/.config/zinit/plugins/${plugin_name}" ]] || [[ -d "$HOME/.config/zinit/snippets/${plugin_name}" ]]
}

if ! is_zinit_installed "OMZ::plugins/z"; then
	zinit snippet OMZ::plugins/z # z jump around directories with ease
fi

if ! is_zinit_installed "OMZ::plugins/jsontools"; then
	zinit snippet OMZ::plugins/jsontools # json tools
fi

if ! is_zinit_installed "loiccoyle/zsh-github-copilot"; then
	zinit light loiccoyle/zsh-github-copilot # github copilot
fi

if ! is_zinit_installed "ael-code/zsh-colored-man-pages"; then
	zinit light ael-code/zsh-colored-man-pages # colored man pages
fi

if ! is_zinit_installed "zsh-users/zsh-autosuggestions"; then
	zinit light zsh-users/zsh-autosuggestions # autosuggestions - use ctrl+f key to accept suggestion
fi

if ! is_zinit_installed "Aloxaf/fzf-tab"; then
	zinit light Aloxaf/fzf-tab # fzf - fuzzy finder completion tab
fi

if ! is_zinit_installed "zsh-users/zsh-syntax-highlighting"; then
	zinit light zsh-users/zsh-syntax-highlighting # syntax highlighting - colorize commands and options
fi

# completions - use tabkey to complete commands and options
autoload -Uz compinit
zinit ice wait lucid
zinit light zdharma-continuum/fast-syntax-highlighting
zinit light zsh-users/zsh-completions
rm -f ~/.zcompdump
compinit -d "$HOME/.logs.d/zcompdump"
