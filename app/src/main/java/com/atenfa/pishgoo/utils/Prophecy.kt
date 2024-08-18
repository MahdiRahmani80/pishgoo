package com.atenfa.pishgoo.utils

object Prophecy {

  fun getProphecy(index: Int): String {
    return prophecyList.shuffled()[index].trim()
  }
  private val prophecyList =
      listOf(
          "امروز رو شل کن فقط خل بازی دربیار",
          "امروز به دوستت زنگ خواهی زد اسکلش خواهی کرد",
          "امروز بشین و غروب خورشید و ببین و لذت ببر",
          " یه نامه واسه ۶۶ سالگیت بنویس",
          "امروز برای دوستت یه نامه روی کاغذ بنویس (یکم ضایع هست، اما باور کن خیلی حال میکنه باهاش)",
          "دهنت خیلی بو میده، مسواک بزن \uD83D\uDE05",
          "امشب اگه زود تر از ۱۰ بخوابی، ۳۰ درصد گناهانت رو بتمن گردن میگیره\uD83D\uDE01",
          "این بیخبران در طلبش بی خبرانند// کان را که خبر شد خبری باز نیامد",
          "خطر حرف های مزخرفت امروز زیاده، سعی کن زیاد حرف نزنی، مخصوصا با خودت \uD83D\uDE05",
          "امروز هاینبرگ خرته \uD83D\uDE02\uD83D\uDE02",
          "مثلا، امروز بخشنده ترین آدم جهان خودتی مشتی",
          " تو فردا به چشم هات کود لوبیای سحرامیز میدی",
          "داستان های بزرگ با یک قدم شروع میشن.\uD83D\uDEB6",
          "فراموش نکن که تو همیشه تو ذهن مایی.\uD83E\uDDE0",
          "خوب رفتار نکن با رفتار های سرد.\uD83E\uDD76",
          "تو دوباره گرسنه میشی یه ساعت دیگه.\uD83E\uDD24",
          "شاید دنیا صدف تو باشه اما این به این معنی نیست که تو مرواریدش میشی.",
          "ما چیزی درمورد آینده نمی دونیم اما یه بیسکویت داریم.\uD83C\uDF6A",
          "بزرگترین خطر میتونه خریت (حماقت) باشه.\uD83E\uDD2A",
          "تو میل به دزدی داری ، یه چیزی بگیر براش.",
          "آدم چاق نمیترسه از بلندی ها ، میترسه از وسعت ها (پهنا ها).\u200C",
          "امروز تو یه سوال ریاضی حل میکنی و میبینی که اصلا ازش بدت نمیاد!",
          "امروز یهو با یه جوک مسخره این قدر میخندی که تهش کارت به جا های باریک میکشه :)",
          "امروز وقتی داری با خودکار مینویسی دستت رو خودکاری میکنی",
          "امروز یه آهنگ باحال پیدا میکنی، اگه پیدا کردی برای منم بفرست :)",
          "امروز ۱۰ هزار تومن پول پیدا میکنی، اگه بیشتر پیدا کردی شماره کارتم رو برات میفرستم",
          "به احتمال ۱۶ درصد تو میتونی به آینده سفر کنی",
          "به احتمال ۴۹ درصد میتونی گذشته رو فراموش کنی",
          " احتمال داره که امروز عشق زندگیتو پیداکنی اما حد اقل باید بری بیرون",
          "خفن با زندگیت میکنی به احتمال ۳۰ درصد امروز یه کار ",
          "، زیر چشی هم نیگا نکن چشم ها تو ببند و هیچی فکر نکن",
          "امروز یه یوزپلنگ میبینی که شبیه گربه هست",
          "اگه هوا باروونی هست و غمگینی یه آهنگ پلی کن و چایی بنوش",
          "شاید امروز یه دوست جدید پیدا کنی",
          "شاید امروز یه داستانی پیش بیاد که دیگه پیش نیاد",
          " امروز یه فرصت جالبی بهت پیشنهاد میشه که به احتمال ۸۸ درصد باید قبولش کنی مگر این که خیلی فرصت داغونی باشه",
          "امروز شانش پیدا کردن یه شغل درست درمون و آبرومند رو داری",
          " امروز میتونی برای همیشه خز بازی رو کنار بذاری، میدونستی ؟",
          "امروز پا میشی و برای زندگیت برنامه ریزی میکنی، سکوت، حل ندارم هم نشد جواب",
          "توی حموم یه ایده ناب به ذهنت میرسه",
          "یک اتفاق امحانی در پیش است",
          "داستان یک پایان، شروع یک آغاز یواشی است در پس تاریکی",
          "چشم های سرو بر طلوع مینگرد ",
          "شاید امروز یک کتاب داستان جدید رو شروع کنی",
          "شاید امروز بخوای یه زبان جدید رو شروع کنی، پیشنهاد من زبون فضایی ها است!!",
          "پنجره منتظر تو هست، شاید در پس پنجره غریبه ای را ببینی",
          "شاید امروز یه فیلم خوب پیدا کنی و ببینی",
          "شاید روزی ز سر سنگ عقابی به هوا خواست",
          "توانا بود هر که دانا بود",
          "گرت عیب جویی بود در سرشت//نبینی جر طاووس دو پای زشت!",
          "درد عشقی کشیده ام که مپرس// زهر هجری کشیده ام که مپرس",
          "در کوی نیک نامان مارا گذر ندادند//گرتونمی پسندی تغییرده قضا را",
          "شاید امروز یه غذای درست و حسابی بخوری",
          "اگه امروز حالت خوبه برای اینه که اون مورچه ها رو نکشتی!",
          "اگه امروز حال داری برو پیداده روی، بعدا دعام میکنی",
          "اگه یه خر دیدی باهاش مهربون باش",
          "!امروز اینستا نرو، رفتی پای خودت",
          "زبان سرخ سر سبز میدهد بر باد و بوران",
          "اگه داداشت امروز حال نداره اذیتش نکن",
          "بهش زنگ بزن",
          "بهش پیام بده",
          "منتظر نباش",
          "ولش کن بره",
          "برو سرچ کن بی مزه ترین جوک های تاریخ بشریت بعد برای مامانت اون ها رو بخون :)",
          "امروز برو برا خودت یه بستنی بخر و حال کن، یادت نره خیلی ها همینشم ندارن :)",
          "خطر باد های شمالی ",
          "خطر شب های طولانی",
          "شنونده باید عاقل باشه داداش",
          "روز های خوب هم میاد",
          "همیشه که نباید خوش و خرم بود، اما خوش بودن یه انتخابه، میگیری چی میگم",
          "رستم میره دارو خونه میگه من به این سوسول بازی ها اعتقاد ندارم!",
          "کفشدوزک رفته بقال شده، دنیای کوچیکیه!",
          "بتمنم حالا شده مدافع حقوق اونا، بابا بسه دیگه",
          "مرد عنکبوتی هم تار میزنه، نوازنده هم تار میزنه، تو هم تار میزنی؟؟ اع از کی تاحالا؟",
          "مرد آهنی هم دیگه سیبیل نمیذاره تو دیگه چرا!",
          "امروز جوکر خونت زیاده",
          "یکم فاز نگیری نمیگن نولی، میگن ارتی!!",
          "توانایی ها تو برای مدت کوتاهی سه برابر میشن، قدرش رو بدون به جان عمو هالک",
          "هالک برای شما هفته پر از اعصاب خوردی آرزو میکنه اما کیه که با هالک اعتقاد داشته باشه!",
          "و میترا اید بانوی نور و روشنایی آتشی میافروز.",
          "چیستا ایزد بانوی دانایی بر سمت چپ دوشتان نشسته است!",
          "رستم میره نونوایی میگه: منم رستم دستان،پهلوان جهان",
          "امروز اینقدر رستم ورزش کرده و پر زور شده که اون روی اسبش جا نمیشه، پس مجبوره اسبش بندازه روی دوشش",
          "امروز هیتلر سبیلش رو میزنه!",
          "شاید جوزف استالین هم آدم بشه",
          "اگه امروز برق رفت فقط ناسزا گفتن به ۱۰ نفر رو بتمن گردن میگیره",
          "اگه امروز هوا خوب بود، افراسیاب پیشنهاد میده که با سهراب بریم قدم بزنیم",
          "رودابه میگه چخبر",
          "سهراب میگه: چشم ها رو باید شست، خا",
          "پرواز کردن رو باید از خفاش یاد گرفت، جز پستانداران هست، کور هست، پر هم نداره، الگو نماد بتمن هم هست، نماد خون آشام هام هست!!",
          "اگه زرافه دیدی بهش نگو دراز بیقواره!",
          "اگه پلنگ دیدی مواظب شیر های اطرافش هم باش",
          "اگه آب سرد میخوری هم مواظب باش چاق نشی",
          "پس کی میخوای یه سر و سامونی به خودت بدی؟‌فردا؟",
          "الان تو ناراحت، تو الان بی حال، بی حوصله، که میتونه حالت و خوب کنه؟؟ بجز خودت",
          "اگه سم رو با خلص نیت هم بخوری میمیری",
          "از دوستی خاله خرسه بر حذر باش",
          "قلت املاعی نداشح باشیید چو بی اغلی میعاره",
          "محمود نونوای محل ما وقتی رستم دستان میاد پیشش به احترامش بهش نون بدون نوبت میده، البته که کار اشتباهی میکنه",
          "یه امروز رو با زئوس بگذرون",
          "!امروز هرکول و آرش کمانگیر میخوان مسابقه بدن، ببینیم کی میبره",
          "تروآ هم یه پاشنه ضعیف داشت!",
          "اسکندر مقدونی رفت پیش ترامپ، دید ترامپ زیاد جیغ جیغ میکنه زد کشتتش!",
          "یه روز آتنا و رودابه داشتن دعوا میکردن، یهو جوکر پرید وسط گفت، اصلن من از همه خوشگل ترم",
          "اگه دلتنگی بادبادک هوا کن",
          "افلاطون اومد پیش من شاگردی گفتم اگه میخواستی چیز یادبگیری از همون سقراط یاد میگرفتی!",
          "اگه ولدمورت اومد مذاکره کنه، باهاش درگیر نشو، ریز خدافظی کن برو",
          "دامبلدور اطرافت رو بشناس",
          "یه روز حضرت عیسی رفت پیاده روی، بتمن بهش تیکه انداخت، حضرت گفت: خداروشکر من عاقلم",
          "گرگ وقتی عاشق میشه، میدونی؟ نه نمیدونم چون من گرگ نیستم!",
          "اگه یه کفتار توی خیابون دیدی مثل لاشخور باهاش رفتار نکن، مثل سگ رفتار کن",
          "اگه یکی خواست ناراحتت کنه، هدفش ناراحت کردن توعه، اگه به روت نیاری خودش نارحت میشه",
          "امروز عصای جادویی هری پاتر رو پیدا میکنید",
          "اورانوس، پدر آسمان نگاهی عاقل اندر سفی به گایا، مادر زمین میاندازد، میخواهد صحبت کند اما از صحبت باز میماند",
          "هرا در کمین است!!",
          "چشمانت امروز شبیه آرس شده!",
          "آتنا الهه خرد، از قلب معصومان دفاع میکند",
          "امروز کمی خلق و خوی هرمس پیدا میکنی!",
          "دیروز دود بودی، امروز کربن، پسفردا الماس!",
          "امروز همه جا آبی میشه",
          "اگه سبز بشه، میریم!",
          "اگه پر داشتی پرواز کن، اگه دوپا داشتی بال بساز، البته اگه بخوای پرواز کنی!",
          "اگه بی حوصله ای و از خودت بدت میاد، بیا ریاضی بخون،اون وقت دیگه از خودت بدت نمیاد!",
          "سردته؟ به قطب جنوب فکر کن!",
          "اگه یه آدم فضایی ببینی چجوری باهاش ارتباط برقرار میکنی؟ با خواهرت هم همینجوری رفتار کن!",
          "اگه امروز ۸ تا لیوان آب بخوری خود هارلی کویین توی آخرت شفاعتت رو میکنه که ای کاش نکنه!",
          "این پیام فقط برای مجتبی هست، اگه مجتبی نیستید این پیام رو رها کنید. (مجتبی داداش از برنامه لذت میبری دیگه!)",
          "این پیام برای امیر هست، داداش عرض ارادت :)",
          "با افراد ساده، درونگرا و آرووم دوست بشین، آدم های خوبی هستن!",
          "سوپرمن اشک هاشو پاک کرد و به کوروش کبیر گفت: خداروشکر که کریپتونایت باعث میشه من ضعیف بشم، وگر نه قابل کنترل نبودم!",
          "اگه بروس وین هم اومد بهت پول بده، اعتقادت رو نفروش!",
          "اگه مجبور شدی سم بخوری، بخور، اما لازم نیست ازش لذت ببری!",
          "اگه نصف راه رو رفتی و سر درگمی باید تجدید نظر کنی!",
          "اگه گشنته، میتونی یه ساعت دیگه هم تحمل کنی",
          "هدف آدم ها رو صبح زود بیدار میکنه، نه آلارم",
          "سقوط از تقوا تدریجی هست",
          "اگه یه ستاره تو آسمون داری، براش یه فضاپیما بساز",
          "سرباز اهدافت باش، دشمن خودت",
          "اگه شمشیر دستته پس تنهایی و در محنت!",
          "هر موقع فکر کردی علامه دهری، دو کتاب درست و درمون بخون",
          "یه پادکست خوب کن",
          "شاید یه فیلم جدید مناسب باشه!",
      )
}
