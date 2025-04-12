-- General
lvim.log.level = "warn"
lvim.format_on_save = true
lvim.colorscheme = "lunar"
lvim.leader = "space"

-- Plugins
lvim.plugins = {
  { "tpope/vim-surround" },
  { "nvim-lualine/lualine.nvim" },
  { "preservim/nerdcommenter" },
  { "akinsho/git-conflict.nvim",        config = function() require("git-conflict").setup() end },
  { "folke/trouble.nvim",               cmd = "TroubleToggle" },
  { "lewis6991/gitsigns.nvim" },
  { "folke/todo-comments.nvim",         config = function() require("todo-comments").setup() end },
  { "lervag/vimtex" },
  { "hashivim/vim-terraform" },
  { "towolf/vim-helm" },
  { "stevearc/dressing.nvim" },
  { "williamboman/mason.nvim" },
  { "williamboman/mason-lspconfig.nvim" },
  { "williamboman/mason-null-ls.nvim" }, -- Correct plugin for null-ls integration
}

-- Treesitter
lvim.builtin.treesitter.ensure_installed = {
  "bash", "c", "cpp", "clojure", "elixir", "go", "graphql", "haskell",
  "html", "java", "javascript", "json", "kotlin", "lua", "markdown",
  "php", "python", "ruby", "rust", "scala", "scheme", "sql", "toml",
  "tsx", "typescript", "vim", "yaml", "xml"
}
lvim.builtin.treesitter.highlight.enable = true

-- Core Built-ins
lvim.builtin.alpha.active = true
lvim.builtin.terminal.active = true
lvim.builtin.nvimtree.setup.view.side = "left"
lvim.builtin.nvimtree.setup.renderer.icons.show.git = true

-- Optional: disable buggy illuminate
lvim.builtin.illuminate.active = false

-- Formatter & Linter Setup via mason-null-ls
local mason_null_ls = require("mason-null-ls")

mason_null_ls.setup({
  ensure_installed = { -- Ensure these tools are installed via mason
    "prettier",
    "black",
    "gofmt",
    "rustfmt",
    "clang-format",
    "eslint",
    "shellcheck",
    "luacheck",
    "hadolint",
  },
  automatic_installation = true, -- Automatically install missing tools
})

-- Keybindings
lvim.keys.normal_mode["<C-s>"] = ":w<CR>"
lvim.keys.normal_mode["<leader>tt"] = ":TroubleToggle<CR>"

-- LSPs via Mason
-- LSP Setup via Mason
local lsp = require("lvim.lsp.manager")

-- LSP servers setup
lsp.setup("jsonls")                 -- JSON
lsp.setup("yamlls")                 -- YAML
lsp.setup("tsserver")               -- TypeScript
lsp.setup("gopls")                  -- Go
lsp.setup("pyright")                -- Python
lsp.setup("rust_analyzer")          -- Rust
lsp.setup("terraformls")            -- Terraform
lsp.setup("bashls")                 -- Bash
lsp.setup("html")                   -- HTML
lsp.setup("cssls")                  -- CSS
lsp.setup("marksman")               -- Markdown
lsp.setup("clojure_lsp")            -- Clojure
lsp.setup("elixirls")               -- Elixir
lsp.setup("kotlin_language_server") -- Kotlin
lsp.setup("sqlls")                  -- SQL
lsp.setup("jdtls")                  -- Java

-- Example of adding custom configuration for 'pyright'
lsp.setup("pyright", {
  settings = {
    python = {
      analysis = {
        typeCheckingMode = "basic", -- Can be 'off', 'basic', or 'strict'
        autoSearchPaths = true,
        useLibraryCodeForTypes = true,
      },
    },
  },
})
