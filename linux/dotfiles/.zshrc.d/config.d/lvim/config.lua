-- General
lvim.log.level = "warn"
lvim.format_on_save = false
lvim.colorscheme = "lunar"

vim.opt.number = true
vim.opt.relativenumber = true
vim.opt.shiftwidth = 4
vim.opt.tabstop = 4
vim.opt.wrap = false
vim.opt.incsearch = true
vim.opt.ignorecase = true
vim.opt.smartcase = true
vim.opt.showcmd = true
vim.opt.showmode = true
vim.opt.showmatch = true
vim.opt.hlsearch = true
vim.opt.history = 1000
vim.opt.wildmenu = true
vim.opt.wildmode = "list:longest"
vim.opt.wildignore = "*.docx,*.jpg,*.png,*.gif,*.pdf,*.pyc,*.exe,*.flv,*.img,*.xlsx"
vim.opt.cursorline = true
vim.opt.clipboard = "unnamedplus"

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
  { "goolord/alpha-nvim", dependencies = { "nvim-tree/nvim-web-devicons" } }
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

-- Mapings
lvim.leader = "space"
lvim.keys.normal_mode["<C-s>"] = ":w<CR>"
lvim.keys.normal_mode["<leader>tt"] = ":TroubleToggle<CR>"

-- Resize splits
lvim.keys.normal_mode["<c-up>"] = "<c-w>+"
lvim.keys.normal_mode["<c-down>"] = "<c-w>-"
lvim.keys.normal_mode["<c-left>"] = "<c-w>>"
lvim.keys.normal_mode["<c-right>"] = "<c-w><"

-- Doom Emacs-style Dashboard settings
lvim.builtin.alpha.active = true
lvim.builtin.alpha.mode = "dashboard"

-- Force dashboard if no file is opened
vim.api.nvim_create_autocmd("VimEnter", {
  callback = function()
    if vim.fn.argc() == 0 then
      require("alpha").start()
    end
  end,
})

local dashboard = lvim.builtin.alpha.dashboard
dashboard.section.buttons.entries = {
  { "SPC f f", "  Find File", "<cmd>Telescope find_files<CR>" },
  { "SPC f r", "  Recent Files", "<cmd>Telescope oldfiles<CR>" },
  { "SPC p p", "  Projects", "<cmd>Telescope projects<CR>" },
  { "SPC s s", "  Search Word", "<cmd>Telescope live_grep<CR>" },
  { "SPC l r", "󰒕  LSP Rename", "<cmd>lua vim.lsp.buf.rename()<CR>" },
  { "q",       "󰅚  Quit LunarVIM", "<cmd>qa<CR>" },
}

-- Doom Emacs–style which-key menu
lvim.builtin.which_key.mappings["p"] = { name = "+project" }
lvim.builtin.which_key.mappings["t"] = { name = "+trouble" }

-- Create submenu 

-- DevOps Submenu
lvim.builtin.which_key.mappings["D"] = {
    name = "+devops",
    d = { "<cmd>DockerToggle<cr>", "Docker" },
    k = { "<cmd>echo 'Kubernetes Dashboard TBD'<cr>", "Kubernetes" },
    a = { "<cmd>echo 'Ansible Playbooks'<cr>", "Ansible" },
    h = { "<cmd>echo 'Helm charts TBD'<cr>", "Helm" },
    v = { "<cmd>echo 'Vagrant up / halt / status TBD'<cr>", "Vagrant" }
}

-- Window Navigation Submenu
lvim.builtin.which_key.mappings["w"] = {
    name = "+window",
    H = { "<C-w>s", "Split below" },
    V = { "<C-w>v", "Split right" },
    s = { "<C-w>j", "Move down" },
    w = { "<C-w>k", "Move up" },
    a = { "<C-w>h", "Move left" },
    d = { "<C-w>l", "Move right" },
    S = { "<C-w>J", "Move window down" },
    W = { "<C-w>K", "Move window up" },
    A = { "<C-w>H", "Move window left" },
    D = { "<C-w>L", "Move window right" }
}

-- Togle Submenu
lvim.builtin.which_key.mappings["T"] = {
    name = "+toggle",
    t = { "<cmd>set relativenumber!<cr>", "Toggle relative number" },
    w = { "<cmd>set wrap!<cr>", "Toggle wrap" }
}

-- LSP Submenu
lvim.builtin.which_key.mappings["l"] = { 
    name = "+lsp",
    i = { "<cmd>LspInfo<cr>", "LSP Info" },
    r = { "<cmd>lua vim.lsp.buf.rename()<cr>", "Rename symbol" },
    a = { "<cmd>lua vim.lsp.buf.code_action()<cr>", "Code action" },
    d = { "<cmd>Telescope diagnostics bufnr=0<cr>", "Buffer diagnostics" }
}

-- Search Submenu
lvim.builtin.which_key.mappings["s"] = {
    name = "+search",
    s = { "<cmd>Telescope live_grep<cr>", "Search word" },
    h = { "<cmd>Telescope help_tags<cr>", "Help tags" }
}

-- Buffers Submenu
lvim.builtin.which_key.mappings["b"] = {
    name = "+buffer", 
    b = { "<cmd>Telescope buffers<cr>", "Switch buffer" },
    d = { "<cmd>bd<cr>", "Delete buffer" }
}

-- Git Submenu
lvim.builtin.which_key.mappings["g"] = { 
    name = "+git",
    g = { "<cmd>LazyGit<cr>", "LazyGit" },
    s = { "<cmd>Gitsigns stage_hunk<cr>", "Stage hunk" },
    u = { "<cmd>Gitsigns undo_stage_hunk<cr>", "Undo stage hunk" }
}

-- File Submenu
lvim.builtin.which_key.mappings["f"] = { 
    name = "+file",
    f = { "<cmd>Telescope find_files<cr>", "Find file"},
    r = { "<cmd>Telescope oldfiles<cr>", "Recent files" },
    s = { "<cmd>w<cr>", "Save file" },
    e = { "<cmd>ene!<cr>", "New file" }
}

