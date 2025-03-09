sudo pacman -S cargo # Install cargo

cargo init ~/cargo # Initialize cargo

# MeowPDF - cat for pdf
git clone https://github.com/monoamine11231/MeowPDF.git && cd MeowPDF && cargo build --release && cargo install --path . && cd .. && rm -rf MeowPDF
