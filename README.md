# StockComedy
Trading game where you buy, sell, and laugh at wacky stock prices!
```
com.pakelcomedy.stockcomedy
├── data
│   ├── model
│   │   ├── Stock.kt
│   │   ├── Crypto.kt
│   │   ├── UserPortfolio.kt
│   │   └── Leaderboard.kt
│   ├── repository
│   │   ├── StockRepository.kt
│   │   ├── CryptoRepository.kt
│   │   ├── PortfolioRepository.kt
│   │   └── LeaderboardRepository.kt
│   └── network
│       └── FirebaseService.kt
├── ui
│   ├── auth
│   │   ├── LoginFragment.kt
│   │   └── LoginViewModel.kt
│   ├── splash
│   │   ├── SplashFragment.kt
│   │   └── SplashViewModel.kt
│   ├── home
│   │   ├── HomeFragment.kt
│   │   ├── HomeViewModel.kt
│   │   ├── stock
│   │   │   ├── StockFragment.kt
│   │   │   └── StockViewModel.kt
│   │   └── crypto
│   │       ├── CryptoFragment.kt
│   │       └── CryptoViewModel.kt
│   ├── earnmoney
│   │   ├── EarnMoneyFragment.kt
│   │   └── EarnMoneyViewModel.kt
│   ├── portfolio
│   │   ├── PortfolioFragment.kt
│   │   ├── PortfolioViewModel.kt
│   │   ├── stock
│   │   │   ├── StockPortfolioFragment.kt
│   │   │   └── StockPortfolioViewModel.kt
│   │   └── crypto
│   │       ├── CryptoPortfolioFragment.kt
│   │       └── CryptoPortfolioViewModel.kt
│   ├── leaderboard
│   │   ├── LeaderboardFragment.kt
│   │   └── LeaderboardViewModel.kt
│   ├── challenges
│   │   ├── ChallengesFragment.kt
│   │   └── ChallengesViewModel.kt
│   ├── chart
│   │   ├── ChartFragment.kt
│   │   └── ChartViewModel.kt
│   └── adapter
│       ├── GeneralAdapter.kt
│       └── LeaderboardAdapter.kt
└── MainActivity.kt
```
```
res
├── anim                     # Animasi (untuk transisi atau efek)
│   ├── fade_in.xml
│   ├── fade_out.xml
│   └── slide_in_right.xml
├── color                    # Warna aplikasi
│   └── colors.xml
├── drawable                 # Gambar dan bentuk yang digunakan di UI
│   ├── ic_launcher_foreground.xml
│   ├── ic_launcher_background.xml
│   ├── background_splash.xml
│   ├── btn_rounded.xml
│   └── card_shadow.xml
├── font                     # Font kustom
│   ├── montserrat_regular.ttf
│   ├── montserrat_bold.ttf
│   └── roboto_medium.ttf
├── layout                   # Layout XML untuk aktivitas dan fragment
│   ├── activity_main.xml
│   ├── fragment_login.xml
│   ├── fragment_splash.xml
│   ├── fragment_home.xml
│   ├── fragment_stock.xml
│   ├── fragment_crypto.xml
│   ├── fragment_earn_money.xml
│   ├── fragment_portfolio.xml
│   ├── fragment_stock_portfolio.xml
│   ├── fragment_crypto_portfolio.xml
│   ├── fragment_leaderboard.xml
│   ├── fragment_challenges.xml
│   ├── fragment_chart.xml
│   └── item_leaderboard.xml
├── menu                     # Menu XML untuk toolbar atau navigasi
│   ├── menu_home.xml
│   └── menu_earn_money.xml
├── mipmap                   # Ikon aplikasi (berbagai ukuran)
│   ├── mipmap-hdpi/ic_launcher.png
│   ├── mipmap-mdpi/ic_launcher.png
│   ├── mipmap-xhdpi/ic_launcher.png
│   ├── mipmap-xxhdpi/ic_launcher.png
│   └── mipmap-xxxhdpi/ic_launcher.png
├── raw                      # File mentah (audio, video, dll.)
│   └── success_sound.mp3
├── values                   # File nilai (strings, dimens, styles, dll.)
│   ├── colors.xml
│   ├── dimens.xml
│   ├── strings.xml
│   ├── styles.xml
│   └── themes.xml
├── values-night             # Tema gelap
│   └── themes.xml
└── xml                      # Konfigurasi XML tambahan
    ├── network_security_config.xml
    └── shortcuts.xml
```
